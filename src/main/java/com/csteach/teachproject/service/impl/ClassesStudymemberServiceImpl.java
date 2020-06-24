package com.csteach.teachproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csteach.teachproject.common.config.PageConfig;
import com.csteach.teachproject.common.exception.CommonException;
import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.common.utils.CopyUtils;
import com.csteach.teachproject.common.utils.PageUtils;
import com.csteach.teachproject.dto.MemberStudyParam;
import com.csteach.teachproject.entity.ClassesStudymember;
import com.csteach.teachproject.entity.MemberBase;
import com.csteach.teachproject.entity.MemberCheckin;
import com.csteach.teachproject.mapper.ClassesStudymemberMapper;
import com.csteach.teachproject.mapper.MemberBaseMapper;
import com.csteach.teachproject.service.ClassesStudymemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csteach.teachproject.vo.PageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程学习成员 服务实现类
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Service
public class ClassesStudymemberServiceImpl extends ServiceImpl<ClassesStudymemberMapper, ClassesStudymember> implements ClassesStudymemberService {

    @Autowired
    private ClassesStudymemberMapper classesStudymemberMapper;
    @Autowired
    private MemberBaseMapper memberBaseMapper;



    @Override
    public void getMemberStudyList(MemberStudyParam memberStudyParam, Result result) {
        Page<ClassesStudymember> page = new Page<>(memberStudyParam.getPagenum(), PageConfig.pageSize);

        //昵称是否存在
        MemberBase userByNickname = memberBaseMapper.getUserByNickname(memberStudyParam.getNickname());
        if(null==userByNickname){
            throw new CommonException("昵称不存在");
        }

        QueryWrapper<ClassesStudymember> wrapper = new QueryWrapper<>();
        wrapper.eq("nickname",memberStudyParam.getNickname()).orderByDesc("create_time");
        classesStudymemberMapper.selectPage(page,wrapper);

        PageListVo<ClassesStudymember> pageListVo = PageUtils.createPage(page);

        result.setData(pageListVo);
    }
}
