package com.learnspring.userdetailsapi;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ExcelHelperService {

    public List<UserInfo> readExcelFile(MultipartFile file) throws Exception {
        try (var workbook = new XSSFWorkbook(file.getInputStream())) {
            var sheet = workbook.getSheetAt(0); // Assuming first sheet

            return StreamSupport.stream(sheet.spliterator(), false)
                    .skip(1) // Skip the header row
                    .map(row -> {
                        var user = new UserInfo();
                        user.setName(row.getCell(0).getStringCellValue());
                        user.setAddress(row.getCell(1).getStringCellValue());
                        user.setPhone((int) row.getCell(2).getNumericCellValue());
                        return user;
                    })
                    .collect(Collectors.toList());
        }

    }
}
