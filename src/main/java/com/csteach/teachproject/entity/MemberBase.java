package com.csteach.teachproject.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 会员基础表
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cs_member_base")
public class MemberBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 密钥
     */
    private String authKey;

    /**
     * 1 表示 普通用户 2 表示vip 3 表示svip
     */
    private String viptype;

    /**
     * 会员过期时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date expiredTime;


    /**
     * 用户注册时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;



    /**
     * github
     */
    private String github;

    /**
     * weibo
     */
    private String weibo;

    /**
     * 积分
     */
    private Integer point;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 公司名
     */
    private String company;

    /**
     * 职位
     */
    private String position;

    /**
     * 最后一次登录
     */
    private Integer lastLogin;


}
