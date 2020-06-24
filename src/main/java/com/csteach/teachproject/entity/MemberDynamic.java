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
 * 社区动态
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cs_member_dynamic")
public class MemberDynamic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户头像
     */
    private String avatarUrl;

    /**
     * 动态的标题
     */
    private String title;

    /**
     * 创建的时间
     */
    private Integer createTime;

    /**
     * 1 表示不置顶，2 表示置顶
     */
    private Integer top;

    /**
     * 1 签到 2 文章 3 评论 4 回复 5 视频
     */
    private Integer type;

    /**
     * 跳转的id
     */
    private Integer subId;


}
