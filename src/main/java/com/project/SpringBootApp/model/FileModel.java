package com.project.SpringBootApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
//Hibernate, which rely on default constructors for certain operations,
// such as entity instantiation through reflection.
// Hibernate requires a default (no-argument) constructor for entity classes so that it
// can instantiate objects of those classes via reflection when querying or persisting entities.
@Table(name="fileModel")
public class FileModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String fileName;

    @Lob  //indicate that the content should be stored in a Large Object (LOB) column, which typically supports larger data sizes.
    @Column(name="content")
    private byte[] content;

    @Column(name="fileType")
    private String fileType;

    public FileModel(String fileName, byte[] content, String fileType) {
        this.fileName = fileName;
        this.content = content;
        this.fileType = fileType;
    }
}
