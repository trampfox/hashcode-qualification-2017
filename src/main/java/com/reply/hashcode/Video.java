package com.reply.hashcode;

import java.util.List;

/**
 * Created by trampfox on 23/02/17.
 */
public class Video /*implements Comparable*/ {

  private Integer id;

  private Integer totRequests;

  private List<Request> requests;

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

  public List<Request> getRequests() {
    return requests;
  }

  public void setEndopoints(List<Request> requests) {
    this.requests = requests;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }
  
}
