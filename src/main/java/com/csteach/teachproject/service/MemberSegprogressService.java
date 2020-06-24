package com.csteach.teachproject.service;

import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.dto.SegmentProgressParam;
import com.csteach.teachproject.dto.StudyProgressParam;
import com.csteach.teachproject.entity.MemberSegprogress;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员视频学习进度 服务类
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
public interface MemberSegprogressService extends IService<MemberSegprogress> {
    public void getSegProgress(SegmentProgressParam segmentProgressParam, Result result);
    public void getSegProgressList(StudyProgressParam studyProgressParam, Result result);
}
