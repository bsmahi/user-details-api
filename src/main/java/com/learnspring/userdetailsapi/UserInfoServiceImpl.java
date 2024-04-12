package com.learnspring.userdetailsapi;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final ExcelHelperService excelHelperService;

    private final UserInfoRepository repository;

    public UserInfoServiceImpl(ExcelHelperService excelHelperService,
                               UserInfoRepository repository) {
        this.excelHelperService = excelHelperService;
        this.repository = repository;
    }

    @Override
    public void createUserDetails(MultipartFile file) throws Exception {
        List<UserInfo> users = excelHelperService.readExcelFile(file);
        repository.saveAll(users);
    }
}
