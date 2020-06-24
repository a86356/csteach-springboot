package com.csteach.teachproject.service;

import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.dto.CheckinQueryParam;
import com.csteach.teachproject.entity.MemberCheckin;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员签到列表 服务类
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Service
public interface MemberCheckinService extends IService<MemberCheckin> {
    public void getCheckinList(CheckinQueryParam checkinQueryParam, Result result);
}
