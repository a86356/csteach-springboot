package com.csteach.teachproject.controller;


import com.alibaba.druid.wall.violation.ErrorCode;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csteach.teachproject.common.constants.ResultCode;
import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.common.utils.CopyUtils;
import com.csteach.teachproject.dto.*;
import com.csteach.teachproject.entity.MemberBase;
import com.csteach.teachproject.mapper.MemberBaseMapper;
import com.csteach.teachproject.service.impl.MemberBaseServiceImpl;
import com.csteach.teachproject.vo.MemberBaseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 会员基础表 前端控制器
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@RestController
@Validated
@Slf4j
public class MemberBaseController {

    @Autowired
    private  MemberBaseServiceImpl memberBaseService;


    @PostMapping("/register")
    public Result register(@RequestBody @Valid RegisterDto registerDto){

        boolean register = memberBaseService.register(registerDto);
        if(register){
            return Result.success();
        }
        return Result.fail("注册失败");
    }


    @PostMapping("/login")
    public Result login(@RequestBody @Valid LoginDto loginDto){
        Result r= new Result();

        //给data设置token
        boolean login = memberBaseService.login(loginDto,r);

        if(login){
            r.setResultCode(ResultCode.SUCCESS);

            return r;
        }

        return Result.fail("注册失败");

    }

    @PostMapping("/changepwd")
    public Result changepwd(@RequestBody @Valid ChangePwdDto changePwdDto){

        Result r= new Result();

        boolean ret = memberBaseService.changepwd(changePwdDto);

        if(ret){
            r.setResultCode(ResultCode.SUCCESS);
            return r;
        }
        return Result.fail("操作失败");

    }



    @Autowired
    private MemberBaseMapper memberBaseMapper;

    @GetMapping("/getlogineduserinfo")
    public Result getlogineduserinfo(){

        Result r= new Result();

        MemberBase loginedUser = memberBaseService.getLoginedUser();
        MemberBaseVo memberBaseVo = new MemberBaseVo();
        BeanUtils.copyProperties(loginedUser, memberBaseVo);

        List<MemberBase> memberBases = memberBaseMapper.selectList(null);
        ArrayList<MemberBaseVo> objects = new ArrayList<>();

        CopyUtils.copyList(memberBases,objects,MemberBaseVo.class);

        r.setData(objects);
        r.setResultCode(ResultCode.SUCCESS);
        return r;
    }


    @PostMapping("/getuserinfo")
    public Result getuserinfo(@RequestBody @Valid  UserQueryParam userQueryParam){

        Result r= new Result();

        MemberBase memberBase =null;
        //1 表示传递的值是手机号
        if(userQueryParam.getType().equals("1")){
            memberBase = memberBaseService.getUserByPhone(userQueryParam.getValue());
        }

        //2 表示传递的值用户名
        if(userQueryParam.getType().equals("2")){
            memberBase = memberBaseService.getUserByusername(userQueryParam.getValue());
        }

        if(null==memberBase){
            return Result.fail("用户信息不存在");
        }

        MemberBaseVo memberBaseVo = new MemberBaseVo();

        CopyUtils.copyObj(memberBase,memberBaseVo);

        r.setData(memberBaseVo);
        r.setResultCode(ResultCode.SUCCESS);
        return r;
    }

    @PostMapping("/saveuserinfo")
    public Result saveuserinfo(@RequestBody @Valid SaveUserInfoDto saveUserInfoDto){

        Result r= new Result();
        MemberBase memberBase = new MemberBase();

        CopyUtils.copyObj(saveUserInfoDto,memberBase);

        MemberBase loginedUser = memberBaseService.getLoginedUser();
        memberBase.setId(loginedUser.getId());

        memberBaseService.updateUserinfo(memberBase);

        r.setResultCode(ResultCode.SUCCESS);
        return r;
    }


    @PostMapping("/getuserlist")
    public Result getuserlist(@RequestBody @Valid UserListQueryParam userListQueryParam){

        Result r= new Result();

        memberBaseService.getUserList(userListQueryParam,r);
        r.setResultCode(ResultCode.SUCCESS);

        return r;
    }
}
