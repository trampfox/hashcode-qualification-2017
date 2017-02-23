package com.reply.hashcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Davide Monfrecola
 */
public class Pool implements Comparable<Pool> {

  private Integer id;

  private Integer minCapacity = 0;

  private Integer maxCapacity = 0;

  private List<Integer> servers = new ArrayList<>();

  private List<Integer> rowCapacities = new ArrayList<>();

  public Pool(int id, int rows) {
	  this.id = id;
	  for(int i = 0; i < rows; i++)
		  rowCapacities.add(0);
  }
  

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getMinCapacity() {
    return minCapacity;
  }

  public void setMinCapacity(Integer minCapacity) {
    this.minCapacity = minCapacity;
  }

  public Integer getMaxCapacity() {
    return maxCapacity;
  }

  public void setMaxCapacity(Integer maxCapacity) {
    this.maxCapacity = maxCapacity;
  }

  public List<Integer> getServers() {
    return servers;
  }

  public void setServers(List<Integer> servers) {
    this.servers = servers;
  }

  public List<Integer> getRowCapacities() {
    return rowCapacities;
  }

  public void setRowCapacities(List<Integer> rowCapacities) {
    this.rowCapacities = rowCapacities;
  }

  public void addServer(final Server server, final Integer rowId) {
    servers.add(server.getId());
    this.maxCapacity += server.getCapacity();
    updateRowCapacity(server, rowId);
    int min = Integer.MAX_VALUE;
    for(Integer rc : rowCapacities) {
    	if(rc < min)
    		min = rc;
    }
    this.minCapacity = min;

    
  }

  public void updateRowCapacity(final Server server, final Integer rowId) {
    final Integer capacity = this.rowCapacities.get(rowId);

    this.rowCapacities.set(rowId, capacity + server.getCapacity());
  }


@Override
public int compareTo(Pool o) {
	if(this.minCapacity == o.minCapacity) {
		if(this.maxCapacity == o.maxCapacity)
			return 0;
		return this.maxCapacity < o.maxCapacity ? -1 : 1;
	}
	return this.minCapacity < o.minCapacity ? -1 : 1;
}

}
