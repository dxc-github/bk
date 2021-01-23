package com.dxc.blog.service;

import com.dxc.blog.pojo.Article;
import com.dxc.blog.pojo.vo.ArticleDateResult;
import com.dxc.blog.pojo.vo.ArticleResult;
import com.dxc.blog.pojo.vo.ArticleVo;

import java.util.List;

public interface ArticleService {
    //分页查询全部的文章、标签、分类
    ArticleResult selectAll(Integer labelId, Integer classiId,String updateDate, Integer page, Integer pageSize);

    //根据文章id查询文章
    ArticleVo selectArticleById(Integer id);

    //根据时间统计每个月文章数量
    List<ArticleDateResult> selecltArticleDateTotal();

    //添加文章
    Boolean addArticle(Article article);

    //根据文章编号修改文章
    Boolean updateArticle(Article article);

    //根据文章编号删除文章
    Boolean deleteArticle(Integer id);
}
