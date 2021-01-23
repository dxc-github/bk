package com.dxc.blog.controller;

import com.dxc.blog.pojo.Classify;
import com.dxc.blog.pojo.Label;
import com.dxc.blog.pojo.vo.LabelResult;
import com.dxc.blog.result.ResultBuilder;
import com.dxc.blog.result.StatusCode;
import com.dxc.blog.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    LabelService labelService;

    @GetMapping("/list")
    ResultBuilder<List<LabelResult>> labelList(){
        List<LabelResult> labels = labelService.selectAll();
        return new ResultBuilder<List<LabelResult>>(labels, StatusCode.SUCCESS);
    }

    @GetMapping("/list/{labelId}")
    ResultBuilder<Label> labelById(@PathVariable Integer labelId){
        Label label = labelService.selectLabelById(labelId);
        return new ResultBuilder<Label>(label, StatusCode.SUCCESS);
    }
}
