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
 * 课程节数
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cs_classes_segments")
public class ClassesSegments implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 大课id
     */
    private Integer classId;

    /**
     * 大课名字
     */
    private String className;

    /**
     * 小课id
     */
    private String segId;

    /**
     * 小课名字
     */
    private String segName;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 时间长度
     */
    private String duration;

    /**
     * 时间长度秒
     */
    private Integer durationS;

    /**
     * 分片播放地址
     */
    private String segurl;

    /**
     * mp4地址
     */
    private String mp4url;

    /**
     * 外部播放地址
     */
    private String outerurl;

    /**
     * 1 表示免费 2 vip
     */
    private Integer isvip;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 1 表示上架，2 表示下架
     */
    private Integer status;


}
