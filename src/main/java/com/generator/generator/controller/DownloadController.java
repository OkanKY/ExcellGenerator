package com.generator.generator.controller;

import com.generator.generator.service.DownloadService;
import com.generator.generator.service.ExcellService;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class DownloadController {

    @Autowired
    ExcellService excellService;
    @Autowired
    DownloadService downloadService;

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException {
        HSSFSheet sheet=excellService.create();
        downloadService.downloadXLS(response,sheet,"test");
    }

}
