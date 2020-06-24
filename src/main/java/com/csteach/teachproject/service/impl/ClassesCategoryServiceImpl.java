package com.csteach.teachproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.entity.ClassesCategory;
import com.csteach.teachproject.mapper.ClassesCategoryMapper;
import com.csteach.teachproject.service.ClassesCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程分类 服务实现类
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Service
public class ClassesCategoryServiceImpl extends ServiceImpl<ClassesCategoryMapper, ClassesCategory> implements ClassesCategoryService {

    @Autowired
    private ClassesCategoryMapper classesCategoryMapper;

    @Override
    public void getAllCategory(Result result) {

        QueryWrapper<ClassesCategory> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        List<ClassesCategory> classesCategories = classesCategoryMapper.selectList(null);
        result.setData(classesCategories);

    }
}
