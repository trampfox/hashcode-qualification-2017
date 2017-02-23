package com.reply.hashcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.reply.hashcode.factories.ModelFactory;
import com.reply.hashcode.helpers.FileHelper;
import com.reply.hashcode.helpers.MatrixHelper;

public class Application {

  public static void main(String[] args) {
	FileHelper fileHelper = new FileHelper();
	String folder = "C:\\Users\\m.omodei\\Downloads\\hashcode-qualification-2017\\src\\main\\java\\resources\\";
	String inputFilePath = folder + "test.in";
	String outputFilePath = folder + "test.out";
	List<String> header = fileHelper.readFileHeader(inputFilePath);
	Map<String, Integer> parameters = MatrixHelper.readMatrixParameters(header);
	List<String> lines = fileHelper.readFileContentByLine(inputFilePath);
	ModelFactory factory = new ModelFactory(lines);
	factory.build();
	List<Video> videos = factory.getVideos();
	ArrayList<Endpoint> endpoints = null;
	ArrayList<CacheServer> servers = null;
	ArrayList<Request> requests = null;
	
	//Collections.sort(videos);
	
	while(videos.size() > 0) {
		Video vid = videos.remove(0);
		if(vid.getRequests().size() == 0)
			continue;
		Request req = vid.getRequests().get(0);
		Endpoint endP = req.getEndpoint();
		Integer best = Integer.MAX_VALUE;
		CacheServer bestCS = null, bestAPCS = null;
		Integer bestAlreadyPresent = Integer.MAX_VALUE;
		for(int i = 0; i < endP.getCacheServerList().size(); i++) {
			CacheServer cs = endP.getCacheServerList().get(i);
			Integer lat = endP.getLatencies().get(i);
			if(cs.getVideos().contains(req.getVideo())) {
				if(lat < bestAlreadyPresent) {
					bestAPCS = cs;
					bestAlreadyPresent = lat;
				}
				break;
			}
			else {
				if(lat >= endP.getDatacenterLatency())
					continue;
				else if(lat < best && cs.getSizeAvailable() >= req.getVideo().getSize()) {
					best = lat;
					bestCS = cs;
				}
			}
		}
		if(bestCS != null) {
			if(bestAPCS != null) {
				double improve = (bestAlreadyPresent - best) / bestAlreadyPresent.doubleValue();
				if(improve > 0.6) {
					vid.setTotRequests(vid.getTotRequests() - req.getNumOfRequests());
					bestCS.addVideo(req.getVideo());
				}
			}
			else {
				vid.setTotRequests(vid.getTotRequests() - req.getNumOfRequests());
				bestCS.addVideo(req.getVideo());
			}
		}
		else if(bestAPCS != null) {
			vid.setTotRequests(vid.getTotRequests() - req.getNumOfRequests());
		}
		if(bestCS != null &vid.getTotRequests() > 0) {
			videos.add(vid);
			Collections.sort(videos, new Comparator<Video>(){

				@Override
				public int compare(Video o1, Video o2) {
					return o1.getTotRequests() - o2.getTotRequests();
				}
					
			});
		}
	}

	fileHelper.writeOutputFile(servers, outputFilePath);

  }
  
}
