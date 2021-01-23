package com.dxc.blog.dao;

import com.dxc.blog.pojo.Label;
import com.dxc.blog.pojo.vo.LabelResult;

import java.util.List;

public interface LabelDao {
    //查询全部标签
    List<LabelResult> selectAll();
    //根据id查询标签
    Label selectLabelById(Integer id);
    //添加标签
    Boolean addLabel(Label label);
    //根据id修改标签
    Boolean updateLabel(Label label);
    //根据id删除标签
    Boolean deleteLabel(Integer id);
}
