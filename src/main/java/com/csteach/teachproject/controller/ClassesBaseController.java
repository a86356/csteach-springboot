package com.csteach.teachproject.controller;


import com.csteach.teachproject.common.constants.ResultCode;
import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.dto.ClassDetailDto;
import com.csteach.teachproject.dto.PageParam;
import com.csteach.teachproject.dto.UserListQueryParam;
import com.csteach.teachproject.service.ClassesBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 课程基础表 前端控制器
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@RestController

public class ClassesBaseController {


    @Autowired
    private ClassesBaseService classesBaseService;

    @PostMapping("/getclasslist")
    public Result getclasslist(@RequestBody @Valid PageParam pageParam){
        Result r= new Result();

        classesBaseService.getClassList(pageParam,r);
        r.setResultCode(ResultCode.SUCCESS);
        return r;
    }


    @PostMapping("/gethotclasslist")
    public Result gethotclasslist(@RequestBody @Valid PageParam pageParam){

        Result r= new Result();

        classesBaseService.getClassList(pageParam,r);
        r.setResultCode(ResultCode.SUCCESS);
        return r;
    }


    @PostMapping("/getclassdetail")
    public Result getclassdetail(@RequestBody @Valid ClassDetailDto classDetailDto){

        Result r= new Result();
        classesBaseService.getClassDetail(classDetailDto,r);
        r.setResultCode(ResultCode.SUCCESS);
        return r;

    }

}
