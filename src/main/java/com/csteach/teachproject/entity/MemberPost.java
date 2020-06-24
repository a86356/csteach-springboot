package com.csteach.teachproject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 帖子
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cs_member_post")
public class MemberPost implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 发帖人昵称
     */
    private String pubNickname;

    /**
     * 发帖人手机号
     */
    private String pubPhone;

    /**
     * 发帖人头像
     */
    private String pubAvatarUrl;

    private Integer type;


}
