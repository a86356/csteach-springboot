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
 * 文章基础表
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cs_article_base")
public class ArticleBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 发布人手机号
     */
    private String pubPhone;

    /**
     * 发布人昵称
     */
    private String pubNickname;

    /**
     * 发布人头像
     */
    private String pubAvatarUrl;

    /**
     * 发布时间
     */
    private Integer createTime;

    /**
     * 文章类型id
     */
    private String typeId;

    /**
     * 文章类型中文
     */
    private String typeName;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容html
     */
    private String contentHtml;

    /**
     * 文章内容md
     */
    private String contentMd;

    /**
     * 阅读量
     */
    private Integer views;

    /**
     * 收藏人数
     */
    private Integer loves;

    /**
     * 评论数
     */
    private Integer commentnum;


}
