package com.csteach.teachproject.controller;


import com.csteach.teachproject.common.constants.ResultCode;
import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.common.utils.CopyUtils;
import com.csteach.teachproject.dto.CheckinQueryParam;
import com.csteach.teachproject.dto.SaveUserInfoDto;
import com.csteach.teachproject.entity.MemberBase;
import com.csteach.teachproject.mapper.MemberBaseMapper;
import com.csteach.teachproject.service.MemberCheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 会员签到列表 前端控制器
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@RestController
public class MemberCheckinController {

    @Autowired
    private MemberCheckinService memberCheckinService;


    @PostMapping("/getcheckinlist")
    public Result getcheckinlist(@RequestBody @Valid CheckinQueryParam checkinQueryParam){

        Result r= new Result();

        memberCheckinService.getCheckinList(checkinQueryParam,r);

        r.setResultCode(ResultCode.SUCCESS);
        return r;
    }


}
