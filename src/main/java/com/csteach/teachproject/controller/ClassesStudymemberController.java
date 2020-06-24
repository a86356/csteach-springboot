package com.csteach.teachproject.controller;


import com.csteach.teachproject.common.constants.ResultCode;
import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.dto.MemberStudyParam;
import com.csteach.teachproject.entity.ClassesStudymember;
import com.csteach.teachproject.entity.MemberBase;
import com.csteach.teachproject.service.ClassesStudymemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 课程学习成员 前端控制器
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@RestController
public class ClassesStudymemberController {

    @Autowired
    private ClassesStudymemberService classesStudymemberService;

    @PostMapping("/getmemberstudylist")
    public Result getmemberstudylist(@RequestBody @Valid MemberStudyParam memberStudyParam){

        Result r= new Result();

        classesStudymemberService.getMemberStudyList(memberStudyParam,r);

        r.setResultCode(ResultCode.SUCCESS);
        return r;
    }
}
