package com.generator.generator.service.impl;

import com.generator.generator.service.ExcellService;

import org.apache.commons.lang3.ArrayUtils;
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

        Double[] inputBoxed = ArrayUtils.toObject(list);
        List<Double> inputAsList = Arrays.asList(inputBoxed);

        System.out.println("min: "+getMin(inputAsList));
        System.out.println("max: "+getMax(inputAsList));
        System.out.println("sum: "+getSum(inputAsList));
        System.out.println("mean: "+getMean(inputAsList));
        System.out.println("median: "+getMedian(inputAsList));
        System.out.println("stdev: "+getStdev(inputAsList));
        System.out.println("mod: "+getMod(inputAsList));

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
                .limit(60000)
                .parallel().toArray();
    }

    private double getMin(List<Double> list){
        return list.stream().min(Double::compare).get().doubleValue();
    }
    private double getMax(List<Double> list){
        return list.stream().max(Double::compare).get().doubleValue();
    }


    private double getSum (List<Double> a){
        if (a.size() > 0) {
            double sum = 0;

            for (Double i : a) {
                sum += i;
            }
            return sum;
        }
        return 0.0;
    }

    private double getMean (List<Double> a){
        double sum = getSum(a);
        double mean = 0;
        mean = sum / (a.size() * 1.0);
        return mean;
    }

    public double getMedian (List<Double> a){
        int middle = a.size()/2;

        if (a.size() % 2 == 1) {
            return a.get(middle);
        } else {
            return (a.get(middle-1) + a.get(middle)) / 2.0;
        }
    }
    private double getStdev (List<Double> a){
        int sum = 0;
        double mean = getMean(a);

        for (Double i : a)
            sum += Math.pow((i - mean), 2);
        return Math.sqrt( sum / ( a.size() - 1 ) ); // sample
    }

    public static <T> T getMod(List<T> list) {
        Map<T, Integer> map = new HashMap<>();

        for (T t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        Map.Entry<T, Integer> max = null;

        for (Map.Entry<T, Integer> e : map.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }

        return max.getKey();
    }
    private String getFormat(double value){
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(value);
    }
}
