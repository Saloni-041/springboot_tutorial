package com.project.SpringBootApp.service;

import com.project.SpringBootApp.model.FileModel;

import java.util.List;

public interface FileService {
     List<FileModel> getAllFiles();
     void saveAllFilesList(List<FileModel> fileList);
}
