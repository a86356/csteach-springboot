package com.csteach.teachproject.controller;


import com.csteach.teachproject.common.constants.ResultCode;
import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.dto.PageParam;
import com.csteach.teachproject.service.ClassesBaseService;
import com.csteach.teachproject.service.ClassesCategoryService;
import com.csteach.teachproject.service.impl.ClassesCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 课程分类 前端控制器
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@RestController
public class ClassesCategoryController {

    @Autowired
    private ClassesCategoryServiceImpl categoryService;

    @PostMapping("/getallcategory")
    public Result getallcategory(){

        Result r= new Result();

        categoryService.getAllCategory(r);
        r.setResultCode(ResultCode.SUCCESS);
        return r;
    }

}
