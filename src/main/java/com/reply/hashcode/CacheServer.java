package com.reply.hashcode;

import java.util.List;

/**
 * Created by trampfox on 23/02/17.
 */
public class CacheServer {

  private Integer id;

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
