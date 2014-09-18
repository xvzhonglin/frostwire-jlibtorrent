/*
 * Created by Angel Leon (@gubatron), Alden Torres (aldenml)
 * Copyright (c) 2011-2014, FrostWire(R). All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.int_vector;
import com.frostwire.jlibtorrent.swig.torrent_handle;
import com.frostwire.jlibtorrent.swig.torrent_handle.status_flags_t;
import com.frostwire.jlibtorrent.swig.torrent_info;
import com.frostwire.jlibtorrent.swig.torrent_status;

/**
 * @author gubatron
 * @author aldenml
 */
public final class TorrentHandle {

    private static final long REQUEST_STATUS_RESOLUTION_MILLIS = 500;

    private final torrent_handle th;

    private long lastStatusRequestTime;
    private TorrentStatus lastStatus;

    public TorrentHandle(torrent_handle th) {
        this.th = th;
    }

    public torrent_handle getSwig() {
        return th;
    }

    public TorrentInfo getTorrentInfo() {
        torrent_info ti = th.torrent_file();
        return ti != null ? new TorrentInfo(th.torrent_file()) : null;
    }

    public boolean isPaused() {
        return th.status().getPaused();
    }

    public boolean isSeeding() {
        return th.status().getIs_seeding();
    }

    public boolean isFinished() {
        return th.status().getIs_finished();
    }

    /**
     * It is important not to call this method for each field in the status
     * for performance reasons.
     *
     * @return
     */
    public TorrentStatus getStatus(boolean force) {
        long now = System.currentTimeMillis();
        if (force || (now - lastStatusRequestTime) >= REQUEST_STATUS_RESOLUTION_MILLIS) {
            lastStatusRequestTime = now;
            lastStatus = new TorrentStatus(th.status());
        }

        return lastStatus;
    }

    public TorrentStatus getStatus() {
        return this.getStatus(false);
    }

    public String getSavePath() {
        torrent_status ts = th.status(status_flags_t.query_save_path.swigValue());
        return ts.getSave_path();
    }

    public String getInfoHash() {
        return LibTorrent.info_hash2string(th.info_hash());
    }

    public void pause() {
        th.pause();
    }

    public void resume() {
        th.resume();
    }

    // This function returns true if any whole chunk has been downloaded
    // since the torrent was first loaded or since the last time the resume
    // data was saved. When saving resume data periodically, it makes sense
    // to skip any torrent which hasn't downloaded anything since the last
    // time.
    //
    //.. note::
    //	A torrent's resume data is considered saved as soon as the alert is
    //	posted. It is important to make sure this alert is received and
    //	handled in order for this function to be meaningful.
    public boolean needSaveResumeData() {
        return th.need_save_resume_data();
    }

    // ``save_resume_data()`` generates fast-resume data and returns it as an
    // entry. This entry is suitable for being bencoded. For more information
    // about how fast-resume works, see fast-resume_.
    //
    // The ``flags`` argument is a bitmask of flags ORed together. see
    // save_resume_flags_t
    //
    // This operation is asynchronous, ``save_resume_data`` will return
    // immediately. The resume data is delivered when it's done through an
    // save_resume_data_alert.
    //
    // The fast resume data will be empty in the following cases:
    //
    //	1. The torrent handle is invalid.
    //	2. The torrent is checking (or is queued for checking) its storage, it
    //	   will obviously not be ready to write resume data.
    //	3. The torrent hasn't received valid metadata and was started without
    //	   metadata (see libtorrent's metadata-from-peers_ extension)
    //
    // Note that by the time you receive the fast resume data, it may already
    // be invalid if the torrent is still downloading! The recommended
    // practice is to first pause the session, then generate the fast resume
    // data, and then close it down. Make sure to not remove_torrent() before
    // you receive the save_resume_data_alert though. There's no need to
    // pause when saving intermittent resume data.
    //
    //.. warning::
    //   If you pause every torrent individually instead of pausing the
    //   session, every torrent will have its paused state saved in the
    //   resume data!
    //
    //.. warning::
    //   The resume data contains the modification timestamps for all files.
    //   If one file has been modified when the torrent is added again, the
    //   will be rechecked. When shutting down, make sure to flush the disk
    //   cache before saving the resume data. This will make sure that the
    //   file timestamps are up to date and won't be modified after saving
    //   the resume data. The recommended way to do this is to pause the
    //   torrent, which will flush the cache and disconnect all peers.
    //
    //.. note::
    //   It is typically a good idea to save resume data whenever a torrent
    //   is completed or paused. In those cases you don't need to pause the
    //   torrent or the session, since the torrent will do no more writing to
    //   its files. If you save resume data for torrents when they are
    //   paused, you can accelerate the shutdown process by not saving resume
    //   data again for paused torrents. Completed torrents should have their
    //   resume data saved when they complete and on exit, since their
    //   statistics might be updated.
    //
    //	In full allocation mode the reume data is never invalidated by
    //	subsequent writes to the files, since pieces won't move around. This
    //	means that you don't need to pause before writing resume data in full
    //	or sparse mode. If you don't, however, any data written to disk after
    //	you saved resume data and before the session closed is lost.
    //
    // It also means that if the resume data is out dated, libtorrent will
    // not re-check the files, but assume that it is fairly recent. The
    // assumption is that it's better to loose a little bit than to re-check
    // the entire file.
    //
    // It is still a good idea to save resume data periodically during
    // download as well as when closing down.
    //
    // Example code to pause and save resume data for all torrents and wait
    // for the alerts:
    //
    // .. code:: c++
    //
    //	extern int outstanding_resume_data; // global counter of outstanding resume data
    //	std::vector<torrent_handle> handles = ses.get_torrents();
    //	ses.pause();
    //	for (std::vector<torrent_handle>::iterator i = handles.begin();
    //		i != handles.end(); ++i)
    //	{
    //		torrent_handle& h = *i;
    //		if (!h.is_valid()) continue;
    //		torrent_status s = h.status();
    //		if (!s.has_metadata) continue;
    //		if (!s.need_save_resume_data()) continue;
    //
    //		h.save_resume_data();
    //		++outstanding_resume_data;
    //	}
    //
    //	while (outstanding_resume_data > 0)
    //	{
    //		alert const* a = ses.wait_for_alert(seconds(10));
    //
    //		// if we don't get an alert within 10 seconds, abort
    //		if (a == 0) break;
    //
    //		std::auto_ptr<alert> holder = ses.pop_alert();
    //
    //		if (alert_cast<save_resume_data_failed_alert>(a))
    //		{
    //			process_alert(a);
    //			--outstanding_resume_data;
    //			continue;
    //		}
    //
    //		save_resume_data_alert const* rd = alert_cast<save_resume_data_alert>(a);
    //		if (rd == 0)
    //		{
    //			process_alert(a);
    //			continue;
    //		}
    //
    //		torrent_handle h = rd->handle;
    //		torrent_status st = h.status(torrent_handle::query_save_path | torrent_handle::query_name);
    //		std::ofstream out((st.save_path
    //			+ "/" + st.name + ".fastresume").c_str()
    //			, std::ios_base::binary);
    //		out.unsetf(std::ios_base::skipws);
    //		bencode(std::ostream_iterator<char>(out), *rd->resume_data);
    //		--outstanding_resume_data;
    //	}
    //
    //.. note::
    //	Note how ``outstanding_resume_data`` is a global counter in this
    //	example. This is deliberate, otherwise there is a race condition for
    //	torrents that was just asked to save their resume data, they posted
    //	the alert, but it has not been received yet. Those torrents would
    //	report that they don't need to save resume data again, and skipped by
    //	the initial loop, and thwart the counter otherwise.
    public void saveResumeData() {
        th.save_resume_data(torrent_handle.save_resume_flags_t.save_info_dict.swigValue());
    }

    public String getDisplayName() {
        torrent_info ti = null;
        if (!th.is_valid() || (ti = th.torrent_file()) == null) {
            return "Unknown";
        }

        String name;

        if (ti.num_files() == 1) {
            name = ti.files().file_name(0);
        } else {
            name = ti.name();
        }

        return name;
    }

    public boolean isPartial() {
        if (!th.is_valid()) {
            return false;
        }

        int_vector v = th.file_priorities();

        long size = v.size();
        for (int i = 0; i < size; i++) {
            if (v.get(i) == 0) {
                return true;
            }
        }

        return false;
    }
}
