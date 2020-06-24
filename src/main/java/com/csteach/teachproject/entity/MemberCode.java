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
 * 用户验证码

 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cs_member_code")
public class MemberCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 验证码
     */
    private String code;

    /**
     * 渠道,比如mob
     */
    private String channel;

    /**
     * 发送时间
     */
    private Integer dateline;

    /**
     * 过期时间
     */
    private Integer expire;

    /**
     * 是否使用过了
     */
    private Integer isUsed;

    /**
     * 使用类型,1表示登录,2注册，3修改密码,4修改支付宝
     */
    private Integer type;


}
