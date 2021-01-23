package com.dxc.blog.controller;

import com.dxc.blog.pojo.Classify;
import com.dxc.blog.result.ResultBuilder;
import com.dxc.blog.result.StatusCode;
import com.dxc.blog.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classify")
public class ClassifyController {
    @Autowired
    ClassifyService classifyService;

    @GetMapping("/list")
    ResultBuilder<List<Classify>> classifyList(){
        List<Classify> classifies = classifyService.selectAll();
        return new ResultBuilder<List<Classify>>(classifies, StatusCode.SUCCESS);
    }

    @GetMapping("/list/{classId}")
    ResultBuilder<Classify> classifyById(@PathVariable Integer classId){
        Classify classifie = classifyService.selectClassifyById(classId);
        return new ResultBuilder<Classify>(classifie, StatusCode.SUCCESS);
    }
}
