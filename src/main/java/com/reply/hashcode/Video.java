package com.reply.hashcode;

import java.util.List;

/**
 * Created by trampfox on 23/02/17.
 */
public class Video {

  private Integer id;

  private Integer totRequests;

  private List<Endpoint> endopoints;

  private Integer size;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getTotRequests() {
    return totRequests;
  }

  public void setTotRequests(Integer totRequests) {
    this.totRequests = totRequests;
  }

  public List<Endpoint> getEndopoints() {
    return endopoints;
  }

  public void setEndopoints(List<Endpoint> endopoints) {
    this.endopoints = endopoints;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }
}
