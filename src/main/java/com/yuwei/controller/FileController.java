package com.yuwei.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/files")
public class FileController {

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file)
            throws IOException {

        String uploadDir = System.getProperty("user.dir") + File.separator + "uploads";

        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(
                originalFilename.lastIndexOf(".")
        );

        String filename = UUID.randomUUID() + suffix;

        File targetFile = new File(dir, filename);

        file.transferTo(targetFile);

        return "http://localhost:8080/uploads/" + filename;
    }
}