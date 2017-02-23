package com.reply.hashcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trampfox on 23/02/17.
 */
public class Video /*implements Comparable*/ {

  private Integer id;

  private Integer totRequests = 0;

  private List<Request> requests;

  private Integer size;

  public Integer getId() {
    return id;
  }
  
  

  public Video(Integer id, Integer size) {
	super();
	this.id = id;
	this.size = size;
	requests = new ArrayList<Request>();

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
