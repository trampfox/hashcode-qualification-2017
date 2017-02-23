package com.reply.hashcode;

/**
 * Created by trampfox on 23/02/17.
 */
public class Request {

  private Endpoint endpoint;

  private Video video;

  private Integer numOfRequests;
  
  


  public Request(Endpoint endpoint, Video video, Integer numOfRequests) {
	this.endpoint = endpoint;
	this.video = video;
	this.numOfRequests = numOfRequests;
}

public Endpoint getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(Endpoint endpoint) {
    this.endpoint = endpoint;
  }

  public Video getVideo() {
    return video;
  }

  public void setVideo(Video video) {
    this.video = video;
  }

  public Integer getNumOfRequests() {
    return numOfRequests;
  }

  public void setNumOfRequests(Integer numOfRequests) {
    this.numOfRequests = numOfRequests;
  }
}
