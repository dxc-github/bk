package com.dxc.blog.service.imp;

import com.dxc.blog.dao.LabelDao;
import com.dxc.blog.pojo.Label;
import com.dxc.blog.pojo.vo.LabelResult;
import com.dxc.blog.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    LabelDao labelDao;

    @Override
    public List<LabelResult> selectAll() {
        return labelDao.selectAll();
    }

    @Override
    public Label selectLabelById(Integer id) {
        return labelDao.selectLabelById(id);
    }

    @Override
    public Boolean addLabel(Label label) {
        return labelDao.addLabel(label);
    }

    @Override
    public Boolean updateLabel(Label label) {
        return labelDao.updateLabel(label);
    }

    @Override
    public Boolean deleteLabel(Integer id) {
        return labelDao.deleteLabel(id);
    }
}
