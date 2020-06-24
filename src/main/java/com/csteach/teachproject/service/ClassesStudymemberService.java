package com.csteach.teachproject.service;

import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.dto.MemberStudyParam;
import com.csteach.teachproject.entity.ClassesStudymember;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程学习成员 服务类
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Service
public interface ClassesStudymemberService extends IService<ClassesStudymember> {
    public void getMemberStudyList(MemberStudyParam memberStudyParam, Result result);

}
