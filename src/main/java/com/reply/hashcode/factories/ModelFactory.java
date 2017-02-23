package com.reply.hashcode.factories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.reply.hashcode.CacheServer;
import com.reply.hashcode.Endpoint;
import com.reply.hashcode.Request;
import com.reply.hashcode.Video;

public class ModelFactory {
	
	private List<String> _lines;
	
	private List<Video> _videos;
	private Map<Integer, Endpoint> _enpointMap;
	
	public ModelFactory(List<String> lines){
		this._lines = lines;
		this._videos = new ArrayList<>();
		this._enpointMap = new HashMap<>();
	}
	
	public List<Video> getVideos() {
		return _videos;
	}
	
	public void build(){
		String[] firstLine = _lines.get(0).split(" ");
		
		int nVideo = Integer.valueOf(firstLine[0]).intValue();
		int nEndPoints = Integer.valueOf(firstLine[1]).intValue();
		int nRequests = Integer.valueOf(firstLine[2]).intValue();
		int cacheSize = Integer.valueOf(firstLine[3]).intValue();
		
		String[] videoSizes = _lines.get(1).split(" ");
		
		// VIDEO
		for(int i=0; i< nVideo; i++){
			_videos.add(new Video(i, Integer.valueOf(videoSizes[0])));
		}
		
		int currentIndex = 1;
		String[] currentLine = null;
		// ENDPOINT
		for(int e=0;e<nEndPoints;e++)
		{	
			
			currentLine = _lines.get(currentIndex).split(" ");
			currentIndex++;
			Integer datacenterLatency = Integer.valueOf(currentLine[0]);
			Integer nCaches = Integer.valueOf(currentLine[1]);
			
			Endpoint ep = new Endpoint(e, datacenterLatency);
			
			List<CacheServer> cacheServers = new ArrayList<>();
			List<Integer> latencies = new ArrayList<>();
			
			// EP - LATENCY
			for(int c=0 ;c < nCaches; c++)
			{
				
				currentLine = _lines.get(currentIndex).split(" ");
				cacheServers.add(new CacheServer(c, cacheSize));
				
				latencies.add(Integer.valueOf(currentLine[1]));
				currentIndex++;
			}
			ep.setCacheServerList(cacheServers);
			ep.setLatencies(latencies);
			_enpointMap.put(ep.getId(), ep);
			
		}
		
		
		
		List<Request> requests = new ArrayList<>();	
		for(int r = 0; r < nRequests; r++){
			currentIndex++;
			currentLine = _lines.get(currentIndex).split(" ");
			Integer idEnpoint = Integer.valueOf(currentLine[0]);
			Integer idVideo = Integer.valueOf(currentLine[1]);
			Integer nunReq = Integer.valueOf(currentLine[2]);
			Request tmp = new Request(_enpointMap.get(idEnpoint), _videos.get(idVideo), nunReq);
			_videos.get(idVideo).addRequest(tmp);
			requests.add(tmp);
		}
		
		
		sortVideos();
		
	}
	
	private void sortVideos(){
		Collections.sort(_videos, new Comparator<Video>(){

			@Override
			public int compare(Video o1, Video o2) {
				return o1.getTotRequests() - o2.getTotRequests();
			}
				
		});
	}
	
	

}
