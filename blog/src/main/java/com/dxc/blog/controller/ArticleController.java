package com.dxc.blog.controller;

import com.dxc.blog.pojo.vo.ArticleDateResult;
import com.dxc.blog.pojo.vo.ArticleResult;
import com.dxc.blog.pojo.vo.ArticleVo;
import com.dxc.blog.result.ResultBuilder;
import com.dxc.blog.result.StatusCode;
import com.dxc.blog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    //分页查询全部文章
    @GetMapping("/list")
    ResultBuilder<ArticleResult> articleList(@RequestParam(defaultValue="1")Integer pageIndex, @RequestParam(defaultValue="10")Integer pageSize){
        logger.info("****"+pageIndex);
        logger.info("****"+pageSize);
        ArticleResult articleResult = articleService.selectAll(null,null,null,pageIndex,pageSize);
        return new ResultBuilder<ArticleResult>(articleResult, StatusCode.SUCCESS);
    }
    //根据标签查询全部文章
    @GetMapping("/list/label/{labelId}")
    ResultBuilder<ArticleResult> articleListByLabel(@PathVariable Integer labelId,
                                                    @RequestParam(defaultValue="1")Integer pageIndex,
                                                    @RequestParam(defaultValue="10")Integer pageSize){
        logger.info("@@@@@"+pageIndex);
        logger.info("@@@@@"+pageSize);
        logger.info("@@@@@"+labelId);
        ResultBuilder<ArticleResult> result;
        ArticleResult articleResult = articleService.selectAll(labelId,null,null,pageIndex,pageSize);
        logger.info(articleResult.getTotal().toString());
        result = new ResultBuilder<ArticleResult>(articleResult, StatusCode.SUCCESS);
        return result;
    }
    //根据分类查询全部文章
    @GetMapping("/list/class/{classId}")
    ResultBuilder<ArticleResult> articleListByClass(@PathVariable Integer classId,
                                                    @RequestParam(defaultValue="1")Integer pageIndex,
                                                    @RequestParam(defaultValue="10")Integer pageSize){
        ResultBuilder<ArticleResult> result;
        ArticleResult articleResult = articleService.selectAll(null,classId,null,pageIndex,pageSize);
        logger.info(articleResult.getTotal().toString());
        result = new ResultBuilder<ArticleResult>(articleResult, StatusCode.SUCCESS);
        return result;
    }
    //根据修改时间查询全部文章
    @GetMapping("/list/date/{updateDate}")
    ResultBuilder<ArticleResult> articleListByCreateTime(@PathVariable String updateDate,
                                                    @RequestParam(defaultValue="1")Integer pageIndex,
                                                    @RequestParam(defaultValue="10")Integer pageSize){
        ResultBuilder<ArticleResult> result;
        ArticleResult articleResult = articleService.selectAll(null,null, updateDate,pageIndex,pageSize);
        logger.info(articleResult.getTotal().toString());
        result = new ResultBuilder<ArticleResult>(articleResult, StatusCode.SUCCESS);
        return result;
    }
    //根据文章id查询文章详情
    @GetMapping("/list/{articleId}")
    ResultBuilder<ArticleVo> articleById(@PathVariable Integer articleId){
        ResultBuilder<ArticleVo> result;
        if(articleId==null){
            result = new ResultBuilder<ArticleVo>(StatusCode.REQUEST_PARAM_ERROR);
            return result;
        }
        ArticleVo articleVo = articleService.selectArticleById(articleId);
        result = new ResultBuilder<ArticleVo>(articleVo, StatusCode.SUCCESS);
        return result;
    }
    //查询最新发布的10篇文章
    @GetMapping("/list/recommend")
    ResultBuilder<ArticleResult> articleRecommendList(@RequestParam(defaultValue="1")Integer pageIndex, @RequestParam(defaultValue="10")Integer pageSize){
        ArticleResult articleResult = articleService.selectAll(null,null,null,1,10);
        return new ResultBuilder<ArticleResult>(articleResult, StatusCode.SUCCESS);
    }
    //根据时间统计最近12个月的文章数量
    @GetMapping("/list/dateTotal")
    ResultBuilder<List<ArticleDateResult>> articleDateTotal(){
        List<ArticleDateResult> articleDateResults = articleService.selecltArticleDateTotal();
        return new ResultBuilder<List<ArticleDateResult>>(articleDateResults, StatusCode.SUCCESS);
    }


}
