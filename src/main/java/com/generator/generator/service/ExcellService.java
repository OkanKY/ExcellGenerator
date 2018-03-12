package com.generator.generator.service;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import java.io.IOException;
import java.util.List;

public interface ExcellService {
    HSSFSheet create() throws IOException;
    List<Double> generateList(int count);
}
