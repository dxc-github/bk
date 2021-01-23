package com.dxc.blog.service.imp;

import com.dxc.blog.dao.ArticleDao;
import com.dxc.blog.pojo.Article;
import com.dxc.blog.pojo.vo.ArticleDateResult;
import com.dxc.blog.pojo.vo.ArticleResult;
import com.dxc.blog.pojo.vo.ArticleVo;
import com.dxc.blog.service.ArticleService;
import com.dxc.blog.utils.PageUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleDao articleDao;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ArticleResult selectAll(Integer labelId, Integer classId,String updateDate, Integer pageIndex, Integer pageSize) {
//        Page page = PageHelper.startPage(pageIndex,pageSize,true);
        List<ArticleVo> articleVoList = articleDao.selectAll(labelId,classId,updateDate);
        logger.info(String.valueOf(articleVoList.size()));
        logger.info(String.valueOf(pageSize));
        logger.info(String.valueOf(pageIndex));
        //总条数
        int total = articleVoList.size();;
        //总页数
        int pages;
        if(articleVoList.isEmpty()==false){
            articleVoList = PageUtil.getPageSizeDataForRelations(articleVoList, pageSize, pageIndex);
            pages = total/pageSize;
            int i = total%pageSize;
            if(i>0){
                pages = pages+1;
            }
            logger.info(String.valueOf(total));
            return new ArticleResult(articleVoList,total,pages);
        }
        total = 0;
        pages = 0;
        logger.info(String.valueOf(total));
        return new ArticleResult(articleVoList,total,pages);
    }

    @Override
    public ArticleVo selectArticleById(Integer id) {
        return articleDao.selectArticleById(id);
    }

    @Override
    public List<ArticleDateResult> selecltArticleDateTotal() {
        return articleDao.selecltArticleDateTotal();
    }

    @Override
    public Boolean addArticle(Article article) {
        return articleDao.addArticle(article);
    }

    @Override
    public Boolean updateArticle(Article article) {
        return articleDao.updateArticle(article);
    }

    @Override
    public Boolean deleteArticle(Integer id) {
        return articleDao.deleteArticle(id);
    }
}
