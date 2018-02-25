package com.generator.generator.service.impl;

import com.generator.generator.service.ExcelWriter;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
@Service
public class ExcelWriterImpl implements ExcelWriter {

	@Override
	public void write(HttpServletResponse response, HSSFSheet sheet) {
		try {
			// Retrieve the output stream
			ServletOutputStream outputStream = response.getOutputStream();
			// Write to the output stream
			sheet.getWorkbook().write(outputStream);
			// Flush the stream
			outputStream.flush();

		} catch (Exception e) {

		}
	}
}
