package com.csteach.teachproject.service;

import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.dto.ClassDetailDto;
import com.csteach.teachproject.dto.PageParam;
import com.csteach.teachproject.entity.ClassesBase;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程基础表 服务类
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Service
public interface ClassesBaseService extends IService<ClassesBase> {
    public void getClassList(PageParam pageParam, Result result);
    public void getClassDetail(ClassDetailDto classDetailDto, Result result);

}
