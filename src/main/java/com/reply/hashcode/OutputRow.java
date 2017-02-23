package com.reply.hashcode;

import java.util.List;

/**
 * @author Davide Monfrecola
 */
public class OutputRow {

  private Integer cacheServerId;

  private List<Video> videos;


  public OutputRow(Integer cacheServerId, List<Video> videos) {
    this.cacheServerId = cacheServerId;
    this.videos = videos;
  }

  public Integer getCacheServerId() {
    return cacheServerId;
  }

  public void setCacheServerId(Integer cacheServerId) {
    this.cacheServerId = cacheServerId;
  }

  @Override
  public String toString() {
    String output;

    output = String.valueOf(cacheServerId);

    for (Video video: videos) {
      output += " " + video.getId();
    }

    return output;
  }
}
