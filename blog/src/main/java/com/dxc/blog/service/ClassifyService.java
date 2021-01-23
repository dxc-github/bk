package com.dxc.blog.service;

import com.dxc.blog.pojo.Classify;

import java.util.List;

public interface ClassifyService {
    //查询全部分类
    List<Classify> selectAll();
    //根据id查询分类
    Classify selectClassifyById(Integer id);
    //添加分类
    Boolean addClassify(Classify classify);
    //根据id修改分类
    Boolean updateClassify(Classify classify);
    //根据id删除分类
    Boolean deleteClassify(Integer id);
}
