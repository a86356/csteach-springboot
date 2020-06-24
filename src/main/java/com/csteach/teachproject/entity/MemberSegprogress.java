package com.csteach.teachproject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 会员视频学习进度
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cs_member_segprogress")
public class MemberSegprogress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 课程id
     */
    private Integer classId;

    /**
     * 节id
     */
    private Integer segId;

    /**
     * 节的名称
     */
    private String segName;

    /**
     * 当前的时间
     */
    private String nowTime;

    /**
     * 总时间
     */
    private String totalTime;

    /**
     * 1 未完 2已完成
     */
    private Integer isEnd;


}
