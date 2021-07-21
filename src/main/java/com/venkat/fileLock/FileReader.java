package com.venkat.fileLock;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.Optional;

public class FileReader {
    private static Logger logger = Logger.getLogger(FileReader.class.getName());

    private String inputFilePath;
    private String readFilePath;

    public Path getOldestFile() throws URISyntaxException, IOException{
        Path destinationPath = null;
        try{
            Path sourceFolder = Paths.get(inputFilePath);
            Path readDir = Paths.get(readFilePath);

            if(Files.exists(sourceFolder) && Files.exists(readDir)){
                Optional<Path> oldestFilePath = Files.list(sourceFolder).filter(f -> !Files.isDirectory(f))
                            .min(Comparator.comparingLong(f -> f.toFile().lastModified()));
                //FIFO
                if(oldestFilePath.isPresent()){
                    logger.info("source file: " + oldestFilePath);
                    destinationPath = readDir.resolve(oldestFilePath.get().getFileName());
                    logger.info("destination file " + destinationPath.toString());
                    try{
                        Files.move(oldestFilePath.get(), destinationPath, StandardCopyOption.ATOMIC_MOVE);
                    }catch (FileSystemException fse){
                        logger.error("File Move failed.." + fse);
                        oldestFilePath = null;
                    }
                }

            }
        }catch (Exception e){
            logger.error("Exception getting oldest file...");
            throw e;
        }
        return destinationPath;
    }

    public static void main(String[] args) throws Exception{
        FileReader fileReader = new FileReader();
        fileReader.getOldestFile();
    }
}
