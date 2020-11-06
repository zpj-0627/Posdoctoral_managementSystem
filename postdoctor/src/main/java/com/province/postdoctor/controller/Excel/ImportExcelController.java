package com.province.postdoctor.controller.Excel;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.province.postdoctor.entity.postdoctor_info.Patent;
import com.province.postdoctor.service.postdoctor_info.PatentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/importExcel")
public class ImportExcelController {

    @Resource
    private PatentService patentService;


    //导入Excel
    @RequestMapping("/import")
    @ResponseBody
    public String importExcel(MultipartFile excelFile) throws Exception {
        log.info("文件名：[{}]",excelFile.getOriginalFilename());
        //excel导入

        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        int sheetNum = params.getSheetNum();
        System.out.println(sheetNum);
        int rows = params.getReadRows();
        System.out.println(rows);
        params.setReadRows(2);
        List<Patent> patents = ExcelImportUtil.importExcel(excelFile.getInputStream(), Patent.class, params);
        patents.forEach(System.out::println);
        System.out.println(patents.size());
        patentService.saveAll(patents);

        return "";//上传完成之后跳转到查询所有信息的路径
    }
}
