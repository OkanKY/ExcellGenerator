package com.generator.generator.service;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import javax.servlet.http.HttpServletResponse;

public interface DownloadService {

    void downloadXLS(HttpServletResponse response, HSSFSheet sheet, String fileName);
}
