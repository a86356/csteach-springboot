package com.csteach.teachproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csteach.teachproject.common.config.PageConfig;
import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.common.utils.PageUtils;
import com.csteach.teachproject.dto.SegmentProgressParam;
import com.csteach.teachproject.dto.StudyProgressParam;
import com.csteach.teachproject.entity.MemberBase;
import com.csteach.teachproject.entity.MemberSegprogress;
import com.csteach.teachproject.mapper.MemberBaseMapper;
import com.csteach.teachproject.mapper.MemberSegprogressMapper;
import com.csteach.teachproject.service.MemberSegprogressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csteach.teachproject.vo.PageListVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员视频学习进度 服务实现类
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Service
@Slf4j
public class MemberSegprogressServiceImpl extends ServiceImpl<MemberSegprogressMapper, MemberSegprogress> implements MemberSegprogressService {

    @Autowired
    private MemberBaseServiceImpl memberBaseService;

    @Autowired
    private MemberSegprogressMapper memberSegprogressMapper;

    @Override
    public void getSegProgress(SegmentProgressParam segmentProgressParam, Result result) {
        QueryWrapper<MemberSegprogress> wrapper = new QueryWrapper<>();
        MemberBase loginedUser = memberBaseService.getLoginedUser();

        wrapper
                .eq("class_id",segmentProgressParam.getClassId())
                .eq("seg_id",segmentProgressParam.getSegId())
                .eq("nickname",loginedUser.getNickname());
        MemberSegprogress memberSegprogress = memberSegprogressMapper.selectOne(wrapper);

        result.setData(memberSegprogress);

    }

    @Override
    public void getSegProgressList(StudyProgressParam studyProgressParam, Result result) {

        Page<MemberSegprogress> page = new Page<>(studyProgressParam.getPageNum(), PageConfig.pageSize);

        QueryWrapper<MemberSegprogress> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");

        if(studyProgressParam.getNickName()!=null){
            wrapper.eq("nickname",studyProgressParam.getNickName());
        }
        memberSegprogressMapper.selectPage(page,wrapper);

        PageListVo<MemberBase> pageListVo = PageUtils.createPage(page);

        result.setData(pageListVo);


    }
}
