package com.project.SpringBootApp.service;

import com.project.SpringBootApp.model.FileModel;
import com.project.SpringBootApp.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpel implements FileService{
    @Autowired
    private FileRepository fileRepository;
    @Override
    public List<FileModel> getAllFiles() {
        List<FileModel> fileList=fileRepository.findAll();
        return fileList;
    }

    @Override
    public void saveAllFilesList(List<FileModel> fileList) {
       for(FileModel fileModel:fileList)
           fileRepository.save(fileModel);
    }
}
