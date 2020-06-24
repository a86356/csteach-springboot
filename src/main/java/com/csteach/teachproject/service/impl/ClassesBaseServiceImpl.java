package com.csteach.teachproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csteach.teachproject.common.config.PageConfig;
import com.csteach.teachproject.common.exception.CommonException;
import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.common.utils.PageUtils;
import com.csteach.teachproject.dto.ClassDetailDto;
import com.csteach.teachproject.dto.PageParam;
import com.csteach.teachproject.entity.ClassesBase;
import com.csteach.teachproject.entity.MemberBase;
import com.csteach.teachproject.mapper.ClassesBaseMapper;
import com.csteach.teachproject.service.ClassesBaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csteach.teachproject.vo.PageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程基础表 服务实现类
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Service
public class ClassesBaseServiceImpl extends ServiceImpl<ClassesBaseMapper, ClassesBase> implements ClassesBaseService {

    @Autowired
    private ClassesBaseMapper classesBaseMapper;

    @Override
    public void getClassList(PageParam pageParam, Result result) {
        Page<ClassesBase> page = new Page<>(pageParam.getPageNum(), PageConfig.pageSize);

        QueryWrapper<ClassesBase> wrapper = new QueryWrapper<>();

        wrapper.orderByDesc("create_time").orderByDesc("lovenum");
        classesBaseMapper.selectPage(page,wrapper);

        PageListVo<MemberBase> pageListVo = PageUtils.createPage(page);

        result.setData(pageListVo);
    }

    @Override
    public void getClassDetail(ClassDetailDto classDetailDto, Result result) {

        ClassesBase classesBase = classesBaseMapper.selectById(classDetailDto.getClassId());
        if(null==classesBase){
            throw new CommonException("没有找到对应的课程");
        }

        result.setData(classesBase);

    }
}
