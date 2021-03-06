package com.reply.hashcode;

import java.util.ArrayList;
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

  public CacheServer(Integer id, Integer size) {
    this.id = id;
    this.size = size;
    this.sizeAvailable = size;
    videos = new ArrayList<Video>();
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

  public List<Video> getVideos() {
    return videos;
  }

  public void setVideos(List<Video> videos) {
    this.videos = videos;
  }

  public Integer getSizeAvailable() {
    return sizeAvailable;
  }

  public void setSizeAvailable(Integer sizeAvailable) {
    this.sizeAvailable = sizeAvailable;
  }

  public Integer getSize() {
    return size;
  }

  public void addVideo(final Video video) {

    if (sizeAvailable - video.getSize() < 0) {
      throw new IllegalStateException("Cache server out of capacity.");
    }
    else {
      sizeAvailable -= video.getSize();
      this.videos.add(video);
    }

  }
}
