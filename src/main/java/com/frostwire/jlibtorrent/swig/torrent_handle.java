/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.frostwire.jlibtorrent.swig;

public class torrent_handle {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected torrent_handle(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(torrent_handle obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtorrent_jni.delete_torrent_handle(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void read_piece(int piece) {
    libtorrent_jni.torrent_handle_read_piece(swigCPtr, this, piece);
  }

  public boolean have_piece(int piece) {
    return libtorrent_jni.torrent_handle_have_piece(swigCPtr, this, piece);
  }

  public void get_peer_info(peer_info_vector v) {
    libtorrent_jni.torrent_handle_get_peer_info(swigCPtr, this, peer_info_vector.getCPtr(v), v);
  }

  public torrent_status status(long flags) {
    return new torrent_status(libtorrent_jni.torrent_handle_status__SWIG_0(swigCPtr, this, flags), true);
  }

  public torrent_status status() {
    return new torrent_status(libtorrent_jni.torrent_handle_status__SWIG_1(swigCPtr, this), true);
  }

  public void get_download_queue(partial_piece_info_vector queue) {
    libtorrent_jni.torrent_handle_get_download_queue(swigCPtr, this, partial_piece_info_vector.getCPtr(queue), queue);
  }

  public void set_piece_deadline(int index, int deadline, int flags) {
    libtorrent_jni.torrent_handle_set_piece_deadline__SWIG_0(swigCPtr, this, index, deadline, flags);
  }

  public void set_piece_deadline(int index, int deadline) {
    libtorrent_jni.torrent_handle_set_piece_deadline__SWIG_1(swigCPtr, this, index, deadline);
  }

  public void reset_piece_deadline(int index) {
    libtorrent_jni.torrent_handle_reset_piece_deadline(swigCPtr, this, index);
  }

  public void clear_piece_deadlines() {
    libtorrent_jni.torrent_handle_clear_piece_deadlines(swigCPtr, this);
  }

  public void set_priority(int prio) {
    libtorrent_jni.torrent_handle_set_priority(swigCPtr, this, prio);
  }

  public void file_progress(int64_vector progress, int flags) {
    libtorrent_jni.torrent_handle_file_progress__SWIG_0(swigCPtr, this, int64_vector.getCPtr(progress), progress, flags);
  }

  public void file_progress(int64_vector progress) {
    libtorrent_jni.torrent_handle_file_progress__SWIG_1(swigCPtr, this, int64_vector.getCPtr(progress), progress);
  }

  public void clear_error() {
    libtorrent_jni.torrent_handle_clear_error(swigCPtr, this);
  }

  public announce_entry_vector trackers() {
    return new announce_entry_vector(libtorrent_jni.torrent_handle_trackers(swigCPtr, this), true);
  }

  public void replace_trackers(announce_entry_vector arg0) {
    libtorrent_jni.torrent_handle_replace_trackers(swigCPtr, this, announce_entry_vector.getCPtr(arg0), arg0);
  }

  public void add_tracker(announce_entry arg0) {
    libtorrent_jni.torrent_handle_add_tracker(swigCPtr, this, announce_entry.getCPtr(arg0), arg0);
  }

  public void add_url_seed(String url) {
    libtorrent_jni.torrent_handle_add_url_seed(swigCPtr, this, url);
  }

  public void remove_url_seed(String url) {
    libtorrent_jni.torrent_handle_remove_url_seed(swigCPtr, this, url);
  }

  public void add_http_seed(String url) {
    libtorrent_jni.torrent_handle_add_http_seed(swigCPtr, this, url);
  }

  public void remove_http_seed(String url) {
    libtorrent_jni.torrent_handle_remove_http_seed(swigCPtr, this, url);
  }

  public boolean set_metadata(byte_const_span metadata) {
    return libtorrent_jni.torrent_handle_set_metadata(swigCPtr, this, byte_const_span.getCPtr(metadata), metadata);
  }

  public boolean is_valid() {
    return libtorrent_jni.torrent_handle_is_valid(swigCPtr, this);
  }

  public void pause(int flags) {
    libtorrent_jni.torrent_handle_pause__SWIG_0(swigCPtr, this, flags);
  }

  public void pause() {
    libtorrent_jni.torrent_handle_pause__SWIG_1(swigCPtr, this);
  }

  public void resume() {
    libtorrent_jni.torrent_handle_resume(swigCPtr, this);
  }

  public void stop_when_ready(boolean b) {
    libtorrent_jni.torrent_handle_stop_when_ready(swigCPtr, this, b);
  }

  public void set_upload_mode(boolean b) {
    libtorrent_jni.torrent_handle_set_upload_mode(swigCPtr, this, b);
  }

  public void set_share_mode(boolean b) {
    libtorrent_jni.torrent_handle_set_share_mode(swigCPtr, this, b);
  }

  public void flush_cache() {
    libtorrent_jni.torrent_handle_flush_cache(swigCPtr, this);
  }

  public void apply_ip_filter(boolean b) {
    libtorrent_jni.torrent_handle_apply_ip_filter(swigCPtr, this, b);
  }

  public void force_recheck() {
    libtorrent_jni.torrent_handle_force_recheck(swigCPtr, this);
  }

  public void save_resume_data(int flags) {
    libtorrent_jni.torrent_handle_save_resume_data__SWIG_0(swigCPtr, this, flags);
  }

  public void save_resume_data() {
    libtorrent_jni.torrent_handle_save_resume_data__SWIG_1(swigCPtr, this);
  }

  public boolean need_save_resume_data() {
    return libtorrent_jni.torrent_handle_need_save_resume_data(swigCPtr, this);
  }

  public void auto_managed(boolean m) {
    libtorrent_jni.torrent_handle_auto_managed(swigCPtr, this, m);
  }

  public int queue_position() {
    return libtorrent_jni.torrent_handle_queue_position(swigCPtr, this);
  }

  public void queue_position_up() {
    libtorrent_jni.torrent_handle_queue_position_up(swigCPtr, this);
  }

  public void queue_position_down() {
    libtorrent_jni.torrent_handle_queue_position_down(swigCPtr, this);
  }

  public void queue_position_top() {
    libtorrent_jni.torrent_handle_queue_position_top(swigCPtr, this);
  }

  public void queue_position_bottom() {
    libtorrent_jni.torrent_handle_queue_position_bottom(swigCPtr, this);
  }

  public void set_ssl_certificate(String certificate, String private_key, String dh_params, String passphrase) {
    libtorrent_jni.torrent_handle_set_ssl_certificate__SWIG_0(swigCPtr, this, certificate, private_key, dh_params, passphrase);
  }

  public void set_ssl_certificate(String certificate, String private_key, String dh_params) {
    libtorrent_jni.torrent_handle_set_ssl_certificate__SWIG_1(swigCPtr, this, certificate, private_key, dh_params);
  }

  public void set_ssl_certificate_buffer(String certificate, String private_key, String dh_params) {
    libtorrent_jni.torrent_handle_set_ssl_certificate_buffer(swigCPtr, this, certificate, private_key, dh_params);
  }

  public void piece_availability(int_vector avail) {
    libtorrent_jni.torrent_handle_piece_availability(swigCPtr, this, int_vector.getCPtr(avail), avail);
  }

  public void piece_priority(int index, int priority) {
    libtorrent_jni.torrent_handle_piece_priority__SWIG_0(swigCPtr, this, index, priority);
  }

  public int piece_priority(int index) {
    return libtorrent_jni.torrent_handle_piece_priority__SWIG_1(swigCPtr, this, index);
  }

  public void prioritize_pieces(int_vector pieces) {
    libtorrent_jni.torrent_handle_prioritize_pieces__SWIG_0(swigCPtr, this, int_vector.getCPtr(pieces), pieces);
  }

  public void prioritize_pieces(int_int_pair_vector pieces) {
    libtorrent_jni.torrent_handle_prioritize_pieces__SWIG_1(swigCPtr, this, int_int_pair_vector.getCPtr(pieces), pieces);
  }

  public int_vector piece_priorities() {
    return new int_vector(libtorrent_jni.torrent_handle_piece_priorities(swigCPtr, this), true);
  }

  public void file_priority(int index, int priority) {
    libtorrent_jni.torrent_handle_file_priority__SWIG_0(swigCPtr, this, index, priority);
  }

  public int file_priority(int index) {
    return libtorrent_jni.torrent_handle_file_priority__SWIG_1(swigCPtr, this, index);
  }

  public void prioritize_files(int_vector files) {
    libtorrent_jni.torrent_handle_prioritize_files(swigCPtr, this, int_vector.getCPtr(files), files);
  }

  public int_vector file_priorities() {
    return new int_vector(libtorrent_jni.torrent_handle_file_priorities(swigCPtr, this), true);
  }

  public void force_reannounce(int seconds, int tracker_index) {
    libtorrent_jni.torrent_handle_force_reannounce__SWIG_0(swigCPtr, this, seconds, tracker_index);
  }

  public void force_reannounce(int seconds) {
    libtorrent_jni.torrent_handle_force_reannounce__SWIG_1(swigCPtr, this, seconds);
  }

  public void force_reannounce() {
    libtorrent_jni.torrent_handle_force_reannounce__SWIG_2(swigCPtr, this);
  }

  public void force_dht_announce() {
    libtorrent_jni.torrent_handle_force_dht_announce(swigCPtr, this);
  }

  public void scrape_tracker(int idx) {
    libtorrent_jni.torrent_handle_scrape_tracker__SWIG_0(swigCPtr, this, idx);
  }

  public void scrape_tracker() {
    libtorrent_jni.torrent_handle_scrape_tracker__SWIG_1(swigCPtr, this);
  }

  public void set_upload_limit(int limit) {
    libtorrent_jni.torrent_handle_set_upload_limit(swigCPtr, this, limit);
  }

  public int upload_limit() {
    return libtorrent_jni.torrent_handle_upload_limit(swigCPtr, this);
  }

  public void set_download_limit(int limit) {
    libtorrent_jni.torrent_handle_set_download_limit(swigCPtr, this, limit);
  }

  public int download_limit() {
    return libtorrent_jni.torrent_handle_download_limit(swigCPtr, this);
  }

  public void set_pinned(boolean p) {
    libtorrent_jni.torrent_handle_set_pinned(swigCPtr, this, p);
  }

  public void set_sequential_download(boolean sd) {
    libtorrent_jni.torrent_handle_set_sequential_download(swigCPtr, this, sd);
  }

  public void connect_peer(tcp_endpoint adr, int source, int flags) {
    libtorrent_jni.torrent_handle_connect_peer__SWIG_0(swigCPtr, this, tcp_endpoint.getCPtr(adr), adr, source, flags);
  }

  public void connect_peer(tcp_endpoint adr, int source) {
    libtorrent_jni.torrent_handle_connect_peer__SWIG_1(swigCPtr, this, tcp_endpoint.getCPtr(adr), adr, source);
  }

  public void connect_peer(tcp_endpoint adr) {
    libtorrent_jni.torrent_handle_connect_peer__SWIG_2(swigCPtr, this, tcp_endpoint.getCPtr(adr), adr);
  }

  public void set_max_uploads(int max_uploads) {
    libtorrent_jni.torrent_handle_set_max_uploads(swigCPtr, this, max_uploads);
  }

  public int max_uploads() {
    return libtorrent_jni.torrent_handle_max_uploads(swigCPtr, this);
  }

  public void set_max_connections(int max_connections) {
    libtorrent_jni.torrent_handle_set_max_connections(swigCPtr, this, max_connections);
  }

  public int max_connections() {
    return libtorrent_jni.torrent_handle_max_connections(swigCPtr, this);
  }

  public void move_storage(String save_path, int flags) {
    libtorrent_jni.torrent_handle_move_storage__SWIG_0(swigCPtr, this, save_path, flags);
  }

  public void move_storage(String save_path) {
    libtorrent_jni.torrent_handle_move_storage__SWIG_1(swigCPtr, this, save_path);
  }

  public void rename_file(int index, String new_name) {
    libtorrent_jni.torrent_handle_rename_file(swigCPtr, this, index, new_name);
  }

  public void super_seeding(boolean on) {
    libtorrent_jni.torrent_handle_super_seeding(swigCPtr, this, on);
  }

  public sha1_hash info_hash() {
    return new sha1_hash(libtorrent_jni.torrent_handle_info_hash(swigCPtr, this), true);
  }

  public boolean op_eq(torrent_handle h) {
    return libtorrent_jni.torrent_handle_op_eq(swigCPtr, this, torrent_handle.getCPtr(h), h);
  }

  public boolean op_ne(torrent_handle h) {
    return libtorrent_jni.torrent_handle_op_ne(swigCPtr, this, torrent_handle.getCPtr(h), h);
  }

  public boolean op_lt(torrent_handle h) {
    return libtorrent_jni.torrent_handle_op_lt(swigCPtr, this, torrent_handle.getCPtr(h), h);
  }

  public long id() {
    return libtorrent_jni.torrent_handle_id(swigCPtr, this);
  }

  public void add_piece_bytes(int piece, byte_vector data, int flags) {
    libtorrent_jni.torrent_handle_add_piece_bytes__SWIG_0(swigCPtr, this, piece, byte_vector.getCPtr(data), data, flags);
  }

  public void add_piece_bytes(int piece, byte_vector data) {
    libtorrent_jni.torrent_handle_add_piece_bytes__SWIG_1(swigCPtr, this, piece, byte_vector.getCPtr(data), data);
  }

  public torrent_info torrent_file_ptr() {
    long cPtr = libtorrent_jni.torrent_handle_torrent_file_ptr(swigCPtr, this);
    return (cPtr == 0) ? null : new torrent_info(cPtr, false);
  }

  public final static class flags_t {
    public final static torrent_handle.flags_t overwrite_existing = new torrent_handle.flags_t("overwrite_existing", libtorrent_jni.torrent_handle_overwrite_existing_get());

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static flags_t swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + flags_t.class + " with value " + swigValue);
    }

    private flags_t(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private flags_t(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private flags_t(String swigName, flags_t swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static flags_t[] swigValues = { overwrite_existing };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

  public final static class status_flags_t {
    public final static torrent_handle.status_flags_t query_distributed_copies = new torrent_handle.status_flags_t("query_distributed_copies", libtorrent_jni.torrent_handle_query_distributed_copies_get());
    public final static torrent_handle.status_flags_t query_accurate_download_counters = new torrent_handle.status_flags_t("query_accurate_download_counters", libtorrent_jni.torrent_handle_query_accurate_download_counters_get());
    public final static torrent_handle.status_flags_t query_last_seen_complete = new torrent_handle.status_flags_t("query_last_seen_complete", libtorrent_jni.torrent_handle_query_last_seen_complete_get());
    public final static torrent_handle.status_flags_t query_pieces = new torrent_handle.status_flags_t("query_pieces", libtorrent_jni.torrent_handle_query_pieces_get());
    public final static torrent_handle.status_flags_t query_verified_pieces = new torrent_handle.status_flags_t("query_verified_pieces", libtorrent_jni.torrent_handle_query_verified_pieces_get());
    public final static torrent_handle.status_flags_t query_torrent_file = new torrent_handle.status_flags_t("query_torrent_file", libtorrent_jni.torrent_handle_query_torrent_file_get());
    public final static torrent_handle.status_flags_t query_name = new torrent_handle.status_flags_t("query_name", libtorrent_jni.torrent_handle_query_name_get());
    public final static torrent_handle.status_flags_t query_save_path = new torrent_handle.status_flags_t("query_save_path", libtorrent_jni.torrent_handle_query_save_path_get());

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static status_flags_t swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + status_flags_t.class + " with value " + swigValue);
    }

    private status_flags_t(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private status_flags_t(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private status_flags_t(String swigName, status_flags_t swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static status_flags_t[] swigValues = { query_distributed_copies, query_accurate_download_counters, query_last_seen_complete, query_pieces, query_verified_pieces, query_torrent_file, query_name, query_save_path };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

  public final static class deadline_flags {
    public final static torrent_handle.deadline_flags alert_when_available = new torrent_handle.deadline_flags("alert_when_available", libtorrent_jni.torrent_handle_alert_when_available_get());

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static deadline_flags swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + deadline_flags.class + " with value " + swigValue);
    }

    private deadline_flags(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private deadline_flags(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private deadline_flags(String swigName, deadline_flags swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static deadline_flags[] swigValues = { alert_when_available };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

  public final static class file_progress_flags_t {
    public final static torrent_handle.file_progress_flags_t piece_granularity = new torrent_handle.file_progress_flags_t("piece_granularity", libtorrent_jni.torrent_handle_piece_granularity_get());

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static file_progress_flags_t swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + file_progress_flags_t.class + " with value " + swigValue);
    }

    private file_progress_flags_t(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private file_progress_flags_t(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private file_progress_flags_t(String swigName, file_progress_flags_t swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static file_progress_flags_t[] swigValues = { piece_granularity };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

  public final static class pause_flags_t {
    public final static torrent_handle.pause_flags_t graceful_pause = new torrent_handle.pause_flags_t("graceful_pause", libtorrent_jni.torrent_handle_graceful_pause_get());

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static pause_flags_t swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + pause_flags_t.class + " with value " + swigValue);
    }

    private pause_flags_t(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private pause_flags_t(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private pause_flags_t(String swigName, pause_flags_t swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static pause_flags_t[] swigValues = { graceful_pause };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

  public final static class save_resume_flags_t {
    public final static torrent_handle.save_resume_flags_t flush_disk_cache = new torrent_handle.save_resume_flags_t("flush_disk_cache", libtorrent_jni.torrent_handle_flush_disk_cache_get());
    public final static torrent_handle.save_resume_flags_t save_info_dict = new torrent_handle.save_resume_flags_t("save_info_dict", libtorrent_jni.torrent_handle_save_info_dict_get());
    public final static torrent_handle.save_resume_flags_t only_if_modified = new torrent_handle.save_resume_flags_t("only_if_modified", libtorrent_jni.torrent_handle_only_if_modified_get());

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static save_resume_flags_t swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + save_resume_flags_t.class + " with value " + swigValue);
    }

    private save_resume_flags_t(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private save_resume_flags_t(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private save_resume_flags_t(String swigName, save_resume_flags_t swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static save_resume_flags_t[] swigValues = { flush_disk_cache, save_info_dict, only_if_modified };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

}
