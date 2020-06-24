package com.csteach.teachproject.controller;


import com.csteach.teachproject.common.constants.ResultCode;
import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.dto.PageParam;
import com.csteach.teachproject.dto.SegmentProgressParam;
import com.csteach.teachproject.dto.StudyProgressParam;
import com.csteach.teachproject.service.MemberSegprogressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 会员视频学习进度 前端控制器
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@RestController
public class MemberSegprogressController {


    @Autowired
    private MemberSegprogressService memberSegprogressService;

    @PostMapping("/getsegprogress")
    public Result getsegprogress(@RequestBody @Valid SegmentProgressParam segmentProgressParam){

        Result r= new Result();

        memberSegprogressService.getSegProgress(segmentProgressParam,r);
        r.setResultCode(ResultCode.SUCCESS);
        return r;
    }


    @PostMapping("/getsegprogresslist")
    public Result getsegprogresslist(@RequestBody @Valid StudyProgressParam studyProgressParam){

        Result r= new Result();

        memberSegprogressService.getSegProgressList(studyProgressParam,r);
        r.setResultCode(ResultCode.SUCCESS);
        return r;
    }

}
