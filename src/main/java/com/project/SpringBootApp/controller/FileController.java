package com.project.SpringBootApp.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

@RestController
public class FileController {

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file")MultipartFile multipartFile) {

        //It uses the current user directory (System.getProperty("user.dir")),
        // File.separator is used to ensure the correct file separator for the operating system.
        // concatenates the original filename of the uploaded file.
        // String filePath=System.getProperty("user.dir")+ File.separator+multipartFile.getOriginalFilename();
        // path->/home/admin1/Documents/Project/SpringBootApp/file_name

        final String UPLOAD_DIRECTORY = "/home/admin1/Downloads"; //it will upload in downloads folder
        String filePath=UPLOAD_DIRECTORY+ File.separator+multipartFile.getOriginalFilename();
        try{
            FileOutputStream fileOutputStream=new FileOutputStream(filePath);
            fileOutputStream.write(multipartFile.getBytes());
            fileOutputStream.close();
            return "File Uploaded Successfully"+filePath;
        }
        catch (Exception e) {
            return "Error in uploading file"+e;
        }
    }

    @GetMapping("/getFiles")
    public String[] getFiles()
    {
//        This line constructs the absolute path to the directory from where you want to retrieve the list of files
        String folderPath="/home/admin1/Downloads";
//        This line creates a new File instance representing the specified directory.
//        The File class in Java is used to represent files and directories on the file system.
        File directory=new File(folderPath);
//        The list() method of the File class returns an array of strings representing the names of files
//        and directories in the specified directory (directory).
        String[] fileNames=directory.list();
        return fileNames;
    }

    @GetMapping("/download/{path}")
    public ResponseEntity downloadFile(@PathVariable("path") String fileName) throws FileNotFoundException {
        String folderPath="/home/admin1/Downloads";
        File directory=new File(folderPath);
        String[] fileNames=directory.list();
        boolean contains= Arrays.asList(fileNames).contains(fileName);

        if(!contains)
            return new ResponseEntity<>("File Not Found", HttpStatus.NOT_FOUND);

        String filePath=folderPath+File.separator+fileName;
        File file=new File(filePath);
//        An InputStreamResource is created from a FileInputStream of the file.
//        This resource will be used to stream the file's content to the client.
        InputStreamResource inputStreamResource=new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers=new HttpHeaders();
        String contentType="application/octet-stream";
        String headerValue = "attachment; filename=\"" + inputStreamResource.getFilename() + "\"";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(inputStreamResource);
    }
}
