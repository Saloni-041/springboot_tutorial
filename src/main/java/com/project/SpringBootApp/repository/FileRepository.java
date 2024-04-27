package com.project.SpringBootApp.repository;

import com.project.SpringBootApp.model.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileModel, Long> {
}
