package com.venkat.fileLock;

import org.apache.log4j.Logger;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MyFileOperations {

    /**
     * Check if the file permission allow
     * file.createExecute() --> return true, file is executable else false
     * file.canWrite() --> return true, file is writable else false
     * file.canRead() --> return true, file is readable else false
     *
     * set the file permission
     * file.setExecutable(boolean executable)
     * file.setReadable(boolean readable)
     * file.setWritable(boolean writable)
     *
     */

    private static Logger logger = Logger.getLogger(MyFileOperations.class.getName());

    public static void main(String[] args) {
        createDirIfNotPresent();
        createFileIfNotPresent();
        readFileContent();
        writeContentIntoFile();
        copyFromSourceToTarget();
        appendContentIntoFile();
        setFilePermissions();
    }

    private static void setFilePermissions(){

        try {
            Path p = Paths.get("myDir/myNewFile3.txt");
            if (Files.exists(p)) {
                System.out.println("File exists...");
            } else {
                Path path = Files.createFile(p);
                System.out.println("File is created: " + path.toString());
            }
        }catch (Exception e){
            System.out.println(e);
        }

        File file = new File("myDir/myNewFile3.txt");
        file.setExecutable(true);
        file.setReadable(true);
        file.setWritable(true);
        System.out.println("Is Execute allows: " + file.canExecute());
        System.out.println("Is write allows: " + file.canWrite());
        System.out.println("Is Read allows: " + file.canRead());

        file.setExecutable(false);
        file.setReadable(false);
        file.setWritable(false);

        System.out.println("**************");

        System.out.println("Is Execute allows: " + file.canExecute());
        System.out.println("Is write allows: " + file.canWrite());
        System.out.println("Is Read allows: " + file.canRead());

    }

    private static void appendContentIntoFile() {
        try{
            Path p = Paths.get("myDir/myNewFile.txt");

            if(Files.exists(p)){
                System.out.println("File exists...");
                String content = "Hi This is another line appended";
                Files.write(p, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);

                Path readFile = Paths.get("myDir/myNewFile.txt");
                List<String> data = Files.readAllLines(readFile);
                for(String line : data){
                    System.out.println(line);
                }
            }else{
                Path path = Files.createFile(p);
                String content = "Hi This is Venkatram R. Veerareddy";
                Files.write(p, content.getBytes(StandardCharsets.UTF_8));
                System.out.println("File is created and added content: " + path.toString());

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void copyFromSourceToTarget(){
        try {
            Path source = Paths.get("myDir/myNewFile.txt");

            Path target = Paths.get("myDir/myNewCopyFile.txt");
            if(!Files.exists(target)) {
                Files.copy(source, target);
                //Files.move(source, target);
                logger.info("Copied from source to target: ");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void writeContentIntoFile() {
        try{
            Path p = Paths.get("myDir/myNewFile.txt");
            if(Files.exists(p)){
                System.out.println("File exists...");
                Path readFile = Paths.get("myDir/myNewFile.txt");
                List<String> data = Files.readAllLines(readFile);
                for(String line : data){
                    System.out.println(line);
                }
            }else{
                Path path = Files.createFile(p);
                String content = "Hi This is Venkatram R. Veerareddy";
                Files.write(p, content.getBytes(StandardCharsets.UTF_8));
                System.out.println("File is created and added content: " + path.toString());

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void readFileContent() {
        try{
            Path p = Paths.get("myDir/myFile.txt");
            List<String> lines = Files.readAllLines(p);
            for(String line: lines){
                System.out.println(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void createFileIfNotPresent() {
        try{
            Path p = Paths.get("myDir/myFile.txt");
            if(Files.exists(p)){
                System.out.println("File exists...");
            }else{
                Path path = Files.createFile(p);
                System.out.println("File is created: " + path.toString());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void createDirIfNotPresent() {
        try{
            Path p = Paths.get("myDir");
            if(Files.exists(p)){
                System.out.println("Directory exists...");
            }else{
                Path path = Files.createDirectories(p);
                System.out.println("Directory is created: " + path.toString());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
