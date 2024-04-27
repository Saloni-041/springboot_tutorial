package com.project.SpringBootApp.controller;

import com.project.SpringBootApp.model.FileModel;
import com.project.SpringBootApp.service.FileServiceImpel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/multiController")
public class MultipleFileController {

    @Autowired
    private FileServiceImpel fileServiceImpel;

    @GetMapping("/get/files")
    public List<FileModel> getData()
    {
        List<FileModel> fileList=new ArrayList<>();
        fileList=fileServiceImpel.getAllFiles();
        return fileList;
    }

    @PostMapping("/add")
    public String uploadMultipartFile(@RequestParam ("files") MultipartFile[] files) {
        try {
            List<FileModel> list = new ArrayList<>();
            for (MultipartFile multipartFile : files) {
                String fileName = multipartFile.getOriginalFilename();
                String fileContentType = multipartFile.getContentType();
                byte[] fileContent = multipartFile.getBytes();  //The content is converted to a byte

                FileModel fileModel=new FileModel(fileName,fileContent,fileContentType);

                list.add(fileModel);
            }
            fileServiceImpel.saveAllFilesList(list);
            return "File uploded sucessfully!";
        }catch (Exception e) {
            return "Exception occured";
        }
    }
}
