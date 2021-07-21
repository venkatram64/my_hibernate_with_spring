package com.venkat.fileLock;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileWriter {
    private static Logger logger = Logger.getLogger(FileWriter.class.getName());
    private static final String VERSION = "1";

    private String targetDirectory;
    private String failedDirectory;
    private String tempDirectory;

    public void write(Path fileName, String content) throws IOException{
        Path targetDir = Paths.get(targetDirectory);
        Path failedDir = Paths.get(failedDirectory);
        Path destinationPath = null;
        Path failedPath = null;

        try{
            if(Files.exists(targetDir) && Files.exists(failedDir)){
                failedPath = failedDir.resolve(fileName.getFileName() + "_" + VERSION);
                destinationPath = targetDir.resolve(fileName.getFileName());
                Files.write(destinationPath, content.getBytes(StandardCharsets.UTF_8));
            }else{
                logger.error("FileWriter paths not available");
                logger.error("Exiting...");
                System.exit(-1);
            }
        }catch(IOException io){
            Files.copy(fileName, failedPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    public void saveTransaction(Path fileName) throws IOException{
        Path tempDir = Paths.get(tempDirectory);
        Path tempPath = null;

        try{
            if(Files.exists(tempDir)){
                tempPath = tempDir.resolve(fileName.getFileName());
                Files.copy(fileName, tempPath, StandardCopyOption.REPLACE_EXISTING);
            }
        }catch(IOException io){
            logger.error("Exception in writing a file...");
            throw io;
        }
    }

}
