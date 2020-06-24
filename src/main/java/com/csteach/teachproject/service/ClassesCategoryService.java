package com.csteach.teachproject.service;

import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.entity.ClassesCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程分类 服务类
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Service
public interface ClassesCategoryService extends IService<ClassesCategory> {
    public void getAllCategory(Result result);
}
