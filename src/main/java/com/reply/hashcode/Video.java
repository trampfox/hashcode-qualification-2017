package com.reply.hashcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trampfox on 23/02/17.
 */
public class Video /*implements Comparable*/ {

  private Integer id;

  private Integer totRequests;

  private List<Request> requests = new ArrayList<Request>();

  private Integer size;

  public Integer getId() {
    return id;
  }
  
  

  public Video(Integer id, Integer size) {
	super();
	this.id = id;
	this.size = size;
}

  public void addRequest(Request r) {
	  this.requests.add(r);
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
