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
 * 课程基础表
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cs_classes_base")
public class ClassesBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 课程名称
     */
    private String classesname;

    /**
     * 课程分类
     */
    private String classescategory;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 课程介绍
     */
    private String introductionHtml;

    /**
     * markdown
     */
    private String introductionMd;

    /**
     * 参考内容
     */
    private String reference;

    /**
     * 课程节数
     */
    private String segnumber;

    /**
     * 课程海报
     */
    private String pic;

    /**
     * 留言数
     */
    private Integer commentnum;

    /**
     * 喜欢数
     */
    private Integer lovenum;

    /**
     * 作者
     */
    private String author;

    /**
     * 1 未更新 2 更新中 3 已完结
     */
    private Integer status;

    /**
     * 1 免费课程 2 收费课程
     */
    private Integer viptype;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 时间长度
     */
    private String duration;

    /**
     * 时间长度秒
     */
    private Integer durationS;


}
