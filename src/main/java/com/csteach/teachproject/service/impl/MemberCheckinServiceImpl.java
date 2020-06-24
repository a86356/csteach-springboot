package com.csteach.teachproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csteach.teachproject.common.config.PageConfig;
import com.csteach.teachproject.common.exception.CommonException;
import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.common.utils.CopyUtils;
import com.csteach.teachproject.common.utils.PageUtils;
import com.csteach.teachproject.dto.CheckinQueryParam;
import com.csteach.teachproject.entity.ClassesStudymember;
import com.csteach.teachproject.entity.MemberBase;
import com.csteach.teachproject.entity.MemberCheckin;
import com.csteach.teachproject.mapper.MemberBaseMapper;
import com.csteach.teachproject.mapper.MemberCheckinMapper;
import com.csteach.teachproject.service.MemberCheckinService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csteach.teachproject.vo.PageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员签到列表 服务实现类
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Service
public class MemberCheckinServiceImpl extends ServiceImpl<MemberCheckinMapper, MemberCheckin> implements MemberCheckinService {

    @Autowired
    private MemberBaseMapper memberBaseMapper;

    @Autowired
    private MemberCheckinMapper memberCheckinMapper;

    @Override
    public void getCheckinList(CheckinQueryParam checkinQueryParam, Result result) {


        //昵称是否存在
        MemberBase userByNickname = memberBaseMapper.getUserByNickname(checkinQueryParam.getNickname());
        if(null==userByNickname){
            throw new CommonException("昵称不存在");
        }

        Page<MemberCheckin> page = new Page<>(checkinQueryParam.getPagenum(), PageConfig.pageSize);
        QueryWrapper<MemberCheckin> wrapper = new QueryWrapper<>();
        wrapper.eq("nickname",checkinQueryParam.getNickname()).orderByDesc("create_time");
        memberCheckinMapper.selectPage(page,wrapper);


        PageListVo<MemberCheckin> pageListVo = PageUtils.createPage(page);

        result.setData(pageListVo);
    }
}
