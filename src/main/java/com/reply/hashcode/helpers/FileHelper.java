package com.reply.hashcode.helpers;

import com.reply.hashcode.CacheServer;
import com.reply.hashcode.OutputRow;
import com.reply.hashcode.Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Davide Monfrecola
 */
public class FileHelper {

  public List<String> readFileContentByLine(final String filename) {
    List<String> lines = new ArrayList<>();

    try(Stream<String> stream = Files.lines(Paths.get(filename))) {

      lines = stream.collect(Collectors.toList());

    } catch (IOException e) {
      e.printStackTrace();
    }

    return lines;
  }

  public List<String> readFileHeader(final String filename) {
    List<String> header = new ArrayList<>();

    try (Stream<String> stream = Files.lines(Paths.get(filename))) {

      header = stream.findFirst().map(l -> Arrays.asList(l.split(" "))).get();

    } catch (IOException e) {
      e.printStackTrace();
    }

    return header;
  }

  public void writeOutputFile(final List<CacheServer> cacheServers,
                              final String outputFilename) {
    final List<OutputRow> outputRows = new ArrayList<>();
    final List<CacheServer> usedCacheServers = new ArrayList<>();

    for (CacheServer cacheServer: cacheServers) {
      if (cacheServer.getVideos().size() > 0) {
        usedCacheServers.add(cacheServer);
      }
    }

    for (CacheServer cacheServer: usedCacheServers) {
      OutputRow outputRow = new OutputRow(cacheServer.getId(), cacheServer.getVideos());
      outputRows.add(outputRow);
    }

    //Use try-with-resource to get auto-closeable writer instance
    try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFilename)))
    {
      outputRows.forEach(row -> {
        try {
          writer.write(row.toString());
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
