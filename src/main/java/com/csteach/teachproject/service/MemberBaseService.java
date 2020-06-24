package com.csteach.teachproject.service;

import com.csteach.teachproject.common.exception.CommonException;
import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.dto.*;
import com.csteach.teachproject.entity.MemberBase;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 会员基础表 服务类
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Service
public interface MemberBaseService extends IService<MemberBase> {

    public boolean register(RegisterDto registerDto) ;
    public boolean login(LoginDto loginDto, Result result);
    public boolean changepwd(ChangePwdDto changePwdDto);
    public MemberBase getLoginedUser();
    public void getUserList(UserListQueryParam userListQueryParam, Result result);
    public MemberBase getUserByPhone(String phone);
    public MemberBase getUserByusername(String username);
    public boolean updateUserinfo(MemberBase memberBase);

}
