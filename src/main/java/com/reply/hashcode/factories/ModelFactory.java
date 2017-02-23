package com.reply.hashcode.factories;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.reply.hashcode.Video;

public class ModelFactory {
	
	private List<String> _lines;
	
	private List<Video> _videos;
	
	public ModelFactory(List<String> lines){
		this._lines = lines;
	}
	
	public void build(){
		String[] firstLine = _lines.get(0).split(" ");
		
		int nVideo = Integer.valueOf(firstLine[0]).intValue();
		int nEndPoints = Integer.valueOf(firstLine[1]).intValue();
		int nRequests = Integer.valueOf(firstLine[2]).intValue();
		int cacheSize = Integer.valueOf(firstLine[3]).intValue();
		
		String[] videoSizes = _lines.get(1).split(" ");
		
		for(int i=0; i< nVideo; i++){
			_videos.add(new Video(i, Integer.valueOf(videoSizes[0])));
		}
		
		for(int e=0;e<nEndPoints;e++){
			
		}
		
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
