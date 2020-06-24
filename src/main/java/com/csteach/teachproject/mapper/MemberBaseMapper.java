package com.csteach.teachproject.mapper;

import com.csteach.teachproject.entity.MemberBase;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 会员基础表 Mapper 接口
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Repository
public interface MemberBaseMapper extends BaseMapper<MemberBase> {

    public MemberBase getUserByUsername(String username);
    public MemberBase getUserByPhone(String phone);
    public MemberBase getUserByToken(String token);
    public MemberBase getUserByNickname(String nickname);

}
