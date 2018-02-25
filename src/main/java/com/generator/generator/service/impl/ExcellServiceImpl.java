package com.generator.generator.service.impl;

import com.generator.generator.service.ExcellService;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

@Service
public class ExcellServiceImpl implements ExcellService {

    @Override
    public HSSFSheet create() throws IOException {
        final HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("generator sheet");

        double[] list= generate();
        int rownum = 0;
        int cellnum = 0;
        Row row = sheet.createRow(rownum);
        for (double key : list) {
            Cell cell = row.createCell(cellnum++);
            cell.setCellValue((String) getFormat(key));
            if(cellnum%15==0) {
                row = sheet.createRow(++rownum);
                cellnum = 0;
            }
        }

        try {
            FileOutputStream out =new FileOutputStream(new File("C:\\new.xls"));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            workbook.close();
        }
        return sheet;
    }

    private  double[] generate(){
       return new Random().doubles(0.0, 15.0)
                .limit(30000)
                .parallel().toArray();
    }

    private String getFormat(double value){
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(value);
    }
}
