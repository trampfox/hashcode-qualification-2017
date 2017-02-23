package com.reply.hashcode;

import java.util.List;

/**
 * Created by trampfox on 23/02/17.
 */
public class CacheServer {

  private Integer id;

  private Integer latency;

  private List<Video> videos;

  private Integer sizeAvailable;

  private final Integer size;

  public CacheServer(Integer size) {
    this.size = size;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getLatency() {
    return latency;
  }

  public void setLatency(Integer latency) {
    this.latency = latency;
  }
}
