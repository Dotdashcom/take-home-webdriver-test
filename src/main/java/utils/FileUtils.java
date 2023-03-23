package utils;

import java.io.File;
import java.time.Instant;

public class FileUtils {

	public boolean isFileDownload(String expectedFileName, String fileExtension,int timeOut) {
		//Download folder path
		String folderName = "C:\\Users\\rajee\\Downloads";
		File[] listOfFile;
		String fileName;
		boolean fileDownload = false;
		long startTime=Instant.now().toEpochMilli();
		long waitTime = startTime + timeOut;
		while(Instant.now().toEpochMilli()<waitTime) {
			//listOfFiles = new File(folderName).listFiles();
			listOfFile = new File(folderName).listFiles();
			for(File file : listOfFile) {
				fileName = file.getName().toLowerCase();
				System.out.println("file name is: "+fileName);
				if(fileName.contains(expectedFileName.toLowerCase()) )
				{
					System.out.println("fileName in if is: "+fileName);
					fileDownload = true;
					break;
					
				}
			}
			 
			if(fileDownload) 

				break;
			
		}
		return fileDownload;
}
}
