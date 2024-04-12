package com.learnspring.userdetailsapi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UserInfoController {

    private final UserInfoService service;

    public UserInfoController(UserInfoService service) {
        this.service = service;
    }

    @PostMapping(value = "/upload-excel", consumes = {"multipart/form-data"})
    public String uploadExcel(@RequestParam("file") MultipartFile file) {
        try {
            service.createUserDetails(file);
            return "Excel data uploaded and inserted into database successfully.";
        } catch (Exception e) {
            return "Error uploading Excel data: " + e.getMessage();
        }
    }
}
