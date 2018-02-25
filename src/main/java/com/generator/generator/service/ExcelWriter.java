package com.generator.generator.service;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import javax.servlet.http.HttpServletResponse;

public interface ExcelWriter {
    void write(HttpServletResponse response, HSSFSheet worksheet);
}
