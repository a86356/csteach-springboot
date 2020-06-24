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
 * 评论基础表
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cs_comment_base")
public class CommentBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 被评论主题的id
     */
    private Integer mainId;

    /**
     * 被评论主题的类型 1 文章 2 视频
     */
    private Integer type;

    /**
     * 评论的楼层数
     */
    private Integer pubFloor;

    /**
     * 发评论人的昵称
     */
    private String pubNickname;

    /**
     * 发评论人的头像
     */
    private String pubAvatarUrl;

    /**
     * 发评论人的内容
     */
    private String pubCnt;

    /**
     * 引用的评论id
     */
    private Integer quoteId;

    /**
     * 引用的楼层
     */
    private Integer quoteFloor;

    /**
     * 引用的昵称
     */
    private String quoteNickname;

    /**
     * 引用的内容
     */
    private String quoteCnt;

    /**
     * 创建时间
     */
    private Integer createTime;


}
