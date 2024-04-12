package com.learnspring.userdetailsapi;

import org.springframework.web.multipart.MultipartFile;

public interface UserInfoService {
    
    void createUserDetails(MultipartFile file) throws Exception;
}
