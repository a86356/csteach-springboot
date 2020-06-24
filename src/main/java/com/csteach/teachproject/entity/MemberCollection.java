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
 * 会员收藏
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cs_member_collection")
public class MemberCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 收藏事物的id
     */
    private Integer subId;

    /**
     * 收藏的类型 1 文章 2 视频
     */
    private Integer type;

    /**
     * 收藏的事物的标题
     */
    private String title;

    private String nickname;

    private String phone;

    private String avatarUrl;

    /**
     * 创建时间
     */
    private Integer createTime;


}
