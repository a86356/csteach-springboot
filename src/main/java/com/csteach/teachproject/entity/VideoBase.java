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
 * 视频基础表
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cs_video_base")
public class VideoBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 视频名称
     */
    private String name;

    /**
     * 上传时间
     */
    private Integer createTime;

    /**
     * 视频长度
     */
    private String duration;

    /**
     * 视频长度 秒
     */
    private Integer durationS;

    /**
     * 视频mp4地址
     */
    private String videoMp4Url;

    /**
     * 视频分片地址
     */
    private String videoSegmentUrl;

    /**
     * 七牛的hash值
     */
    private String hash;


}
