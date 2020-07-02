package com.kooniverse.farm.board;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BoardStorageManager {
    private String documentRootPath;

    private String storageHome;
    private String imageDir;
    private String fileDir;

    public String getImagePath(String fileName) {
        String imagePath = Paths.get(storageHome, imageDir, fileName).toString();
        return imagePath;
    }

    public String getFilePath(String fileName) {
        String filePath = Paths.get(storageHome, fileDir, fileName).toString();
        return filePath;
    }

    public String saveImage(MultipartFile file) {
        String saveDir = Paths.get(documentRootPath, storageHome, imageDir).toString();
        String savedFile = this.saveFile(file, saveDir);

        return savedFile;
    }

    public String saveFile(MultipartFile file) {
        String saveDir = Paths.get(documentRootPath, storageHome, fileDir).toString();
        String savedFile = this.saveFile(file, saveDir);

        return savedFile;
    }

    public String saveFile(MultipartFile file, String saveDir) {
        String targetFileName = file.getOriginalFilename();
        Path filePath = Paths.get(saveDir, targetFileName);

        try {
            // mkdir
            Path savePath = Paths.get(saveDir);
            boolean result = Files.exists(savePath);
            if (!result) {
                Files.createDirectories(savePath);
            }

            // move
            file.transferTo(filePath);
            return targetFileName;

        } catch(Exception e) {
            System.out.println("Error!! : " + e.getMessage());
            return null;
        }
    }


    public String getDocumentRootPath() {
        return documentRootPath;
    }

    public void setDocumentRootPath(String documentRootPath) {
        this.documentRootPath = documentRootPath;
    }

    public String getStorageHome() {
        return storageHome;
    }

    public void setStorageHome(String storageHome) {
        this.storageHome = storageHome;
    }

    public String getImageDir() {
        return imageDir;
    }

    public void setImageDir(String imageDir) {
        this.imageDir = imageDir;
    }

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }
}
