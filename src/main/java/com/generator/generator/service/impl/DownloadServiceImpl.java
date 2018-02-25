package com.generator.generator.service.impl;

import com.generator.generator.service.DownloadService;
import com.generator.generator.service.ExcelWriter;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletResponse;
@Service
public class DownloadServiceImpl implements DownloadService {

    @Autowired
    ExcelWriter excelWriter;

    @Override
    public void downloadXLS(HttpServletResponse response, HSSFSheet sheet, String fileName) {

        response.setHeader("Content-Disposition", "inline; filename=" + fileName + ".xlsx");
        // Make sure to set the correct content type
        response.setContentType("application/vnd.ms-excel");
        // Write to the output stream
        excelWriter.write(response, sheet);
    }
}
