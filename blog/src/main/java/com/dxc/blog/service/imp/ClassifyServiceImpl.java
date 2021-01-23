package com.dxc.blog.service.imp;

import com.dxc.blog.dao.ClassifyDao;
import com.dxc.blog.pojo.Classify;
import com.dxc.blog.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    ClassifyDao classifyDao;
    @Override
    public List<Classify> selectAll() {
        return classifyDao.selectAll();
    }

    @Override
    public Classify selectClassifyById(Integer id) {
        return classifyDao.selectClassifyById(id);
    }

    @Override
    public Boolean addClassify(Classify classify) {
        return classifyDao.addClassify(classify);
    }

    @Override
    public Boolean updateClassify(Classify classify) {
        return classifyDao.updateClassify(classify);
    }

    @Override
    public Boolean deleteClassify(Integer id) {
        return classifyDao.deleteClassify(id);
    }
}
