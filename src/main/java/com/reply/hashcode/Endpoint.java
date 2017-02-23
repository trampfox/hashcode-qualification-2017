package com.reply.hashcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trampfox on 23/02/17.
 */
public class Endpoint {

  private Integer id;

  private List<CacheServer> cacheServerList;

  private Integer datacenterLatency;

  private List<Integer> latencies;

  private List<Request> requests;

  public Endpoint(Integer id, Integer datacenterLatency){
	  this.id = id;
	  this.datacenterLatency = datacenterLatency;
	  cacheServerList = new ArrayList<CacheServer>();
  }
  
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<CacheServer> getCacheServerList() {
    return cacheServerList;
  }

  public void setCacheServerList(List<CacheServer> cacheServerList) {
    this.cacheServerList = cacheServerList;
  }

  public List<Integer> getLatencies() {
    return latencies;
  }

  public void setLatencies(List<Integer> latencies) {
    this.latencies = latencies;
  }

  public Integer getDatacenterLatency() {
    return datacenterLatency;
  }

  public void setDatacenterLatency(Integer datacenterLatency) {
    this.datacenterLatency = datacenterLatency;
  }

  public List<Request> getRequests() {
    return requests;
  }

  public void setRequests(List<Request> requests) {
    this.requests = requests;
  }
}
