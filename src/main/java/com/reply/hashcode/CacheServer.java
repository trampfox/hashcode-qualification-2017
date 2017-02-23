package com.reply.hashcode;

/**
 * Created by trampfox on 23/02/17.
 */
public class CacheServer {

  private Integer id;
  private Integer size;

  public Integer getSize() {
	return size;
}


public void setSize(Integer size) {
	this.size = size;
}

private Integer latency;
  
  public CacheServer(Integer id, Integer size){
	  this.id = id;
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
