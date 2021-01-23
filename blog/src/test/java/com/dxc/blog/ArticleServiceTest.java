package com.dxc.blog;

import com.dxc.blog.pojo.Article;
import com.dxc.blog.pojo.vo.ArticleResult;
import com.dxc.blog.pojo.vo.ArticleVo;
import com.dxc.blog.pojo.Label;
import com.dxc.blog.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class ArticleServiceTest {
    @Autowired
    ArticleService articleService;
    @Test
    void selectTest(){
        ArticleResult a = articleService.selectAll(null,null,null,1,10);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (ArticleVo article:a.getArticleVoList()){
            System.out.print(article.getArticleId()+"/");
            System.out.print(article.getContextSynopsis()+"/");
            System.out.print(article.getTitle()+"/");
            System.out.print(article.getViewCount()+"/");
            System.out.print(article.getClassifyId()+"/");
            System.out.print(article.getClassify().getClassName()+"/");
//            System.out.print(sdf.format(article.getCreateTime())+"/");
            System.out.print(article.getCreateTime()+"/");
            System.out.print(article.getUpdateTime()+"/");
//            System.out.print(sdf.format(article.getUpdateTime())+"/");
            System.out.print("[");
            for(Label label:article.getLabels()){
                System.out.print(label.getLabelId()+"/");
                System.out.print(label.getLabelName()+"/");
            }
            System.out.println("]");
        }
    }
    @Test
    void selectById(){
        ArticleVo article = articleService.selectArticleById(1);
        System.out.print(article.getArticleId()+"/");
        System.out.print(article.getContext()+"/");
        System.out.print(article.getTitle()+"/");
        System.out.print(article.getViewCount()+"/");
        System.out.print(article.getClassifyId()+"/");
        System.out.print(article.getClassify().getClassName()+"/");
//            System.out.print(sdf.format(article.getCreateTime())+"/");
        System.out.print(article.getCreateTime()+"/");
        System.out.print(article.getUpdateTime()+"/");
//            System.out.print(sdf.format(article.getUpdateTime())+"/");
        System.out.print("[");
        for(Label label:article.getLabels()){
            System.out.print(label.getLabelId()+"/");
            System.out.print(label.getLabelName()+"/");
        }
        System.out.println("]");
    }
    @Test
    void add(){
        List<Integer> list =new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        Article article = new Article("Vue和微信小程序的区别、比较"
                ,2
                ,"vue的钩子函数在跳转新页面时，钩子函数都会触发，但是小程序的钩子函数，页面不同的跳转方式，触发的钩子并不一样。"
                ,"<h1>vue的钩子函数在跳转新页面时，钩子函数都会触发，但是小程序的钩子函数，页面不同的跳转方式，触发的钩子并不一样。</h1>"
                ,new Date()
                ,new Date()
                ,list);
        Boolean a = articleService.addArticle(article);
        System.out.println(a);
    }

    @Test
    void update(){
        List<Integer> list =new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        Article article = new Article(6
                ,"Vue和微信小程序的区别、比较"
                ,2
                ,"2vue的钩子函数在跳转新页面时，钩子函数都会触发，但是小程序的钩子函数，页面不同的跳转方式，触发的钩子并不一样。"
                ,"3vue的钩子函数在跳转新页面时，钩子函数都会触发，但是小程序的钩子函数，页面不同的跳转方式，触发的钩子并不一样。"
                ,new Date()
                ,list);
        Boolean a = articleService.updateArticle(article);
        System.out.println(a);
    }
    @Test
    void delete(){
        Boolean a = articleService.deleteArticle(6);
        System.out.println(a);
    }
}
