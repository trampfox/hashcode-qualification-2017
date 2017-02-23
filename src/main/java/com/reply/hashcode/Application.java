package com.reply.hashcode;

import java.util.List;
import java.util.Map;

import com.reply.hashcode.helpers.FileHelper;
import com.reply.hashcode.helpers.MatrixHelper;

public class Application {

  public static void main(String[] args) {
    FileHelper fileHelper = new FileHelper();
    String folder = "C:\\Users\\m.omodei\\Documents\\HashCode\\Ghost-Buggers-Solution\\";
    String inputFilePath = folder + "test.in";
	  String outputFilePath = folder + "test.out";
	  List<String> header = fileHelper.readFileHeader(inputFilePath);
	  Map<String, Integer> parameters = MatrixHelper.readMatrixParameters(header);
	  List<String> lines = fileHelper.readFileContentByLine(inputFilePath);
	//fileHelper.writeOutputFile(servers, outputFilePath);

  }
  
}
