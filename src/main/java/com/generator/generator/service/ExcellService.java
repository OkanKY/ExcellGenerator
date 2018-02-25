package com.generator.generator.service;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import java.io.IOException;

public interface ExcellService {
    HSSFSheet create() throws IOException;
}
