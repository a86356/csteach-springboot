package com.csteach.teachproject.service.impl;

import cn.hutool.core.map.MapBuilder;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csteach.teachproject.common.config.PageConfig;
import com.csteach.teachproject.common.exception.CommonException;
import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.common.myassert.MyAssert;
import com.csteach.teachproject.common.utils.DateUtils;
import com.csteach.teachproject.common.utils.Md5Utils;
import com.csteach.teachproject.common.utils.PageUtils;
import com.csteach.teachproject.common.utils.RandomUtils;
import com.csteach.teachproject.dto.*;
import com.csteach.teachproject.entity.ClassesStudymember;
import com.csteach.teachproject.entity.MemberBase;
import com.csteach.teachproject.mapper.MemberBaseMapper;
import com.csteach.teachproject.service.MemberBaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csteach.teachproject.vo.ListVo;
import com.csteach.teachproject.vo.LoginVo;
import com.csteach.teachproject.vo.MemberBaseVo;
import com.csteach.teachproject.vo.PageListVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 会员基础表 服务实现类
 * </p>
 *
 * @author 关注qq：100000356
 * @since 2020-06-20
 */
@Slf4j
@Service
public class MemberBaseServiceImpl extends ServiceImpl<MemberBaseMapper, MemberBase> implements MemberBaseService {

    @Autowired
    private MemberBaseMapper memberBaseMapper;

    @Autowired
    private DateUtils dateUtils;


    @Autowired
    private RandomUtils randomUtils;

    @Autowired
    private HttpServletRequest request;

    @Override
    public boolean register(RegisterDto registerDto)  {
        //业务逻辑的编写
        //用户名不能重复出现
        MemberBase userByUsername = memberBaseMapper.getUserByUsername(registerDto.getUsername());
        if(userByUsername!=null){
            throw new CommonException("用户已经存在");
        }


        // 手机号不能重复
        MemberBase userByPhone = memberBaseMapper.getUserByPhone(registerDto.getPhone());
        if(userByPhone!=null){
            throw new CommonException("手机号已经存在了,请登录");
        }


        //注册用户
        MemberBase memberBase2 = new MemberBase();
        BeanUtils.copyProperties(registerDto, memberBase2);
        memberBase2.setPassword(Md5Utils.md5(registerDto.getPassword()));
        memberBase2.setAuthKey(randomUtils.getRandomNumAndEnglish(32));
        int i = memberBaseMapper.insert(memberBase2);

        return i > 0;
    }


    @Override
    public boolean login(LoginDto loginDto, Result result) {

        //用户名不存在]
        MemberBase userByUsername = memberBaseMapper.getUserByUsername(loginDto.getUsername());
        if(userByUsername==null){
            throw new CommonException("用户不存在");
        }

          //密码不一样
        if(!Md5Utils.md5(loginDto.getPassword()).equals(userByUsername.getPassword())){
            throw new CommonException("密码错误");
        }

        LoginVo loginVo = new LoginVo();
        loginVo.setAuthKey(userByUsername.getAuthKey());


        result.setData(loginVo);

        //vo view obecject 页面上的对象
        // dto 我们数据传输的对象，

        //直接设置data的值
        result.setData(MapUtil.builder()
                .put("token", userByUsername.getAuthKey())
                .put("username", userByUsername.getUsername())
                .map());


        return true;
    }

    @Override
    public boolean changepwd(ChangePwdDto changePwdDto) {

        //看一下老密码是不是正确的
        MemberBase memberBase = this.getLoginedUser();
        if(!memberBase.getPassword().equals(Md5Utils.md5(changePwdDto.getOldpwd()))){
            throw new RuntimeException("旧密码错误");
        }

        MemberBase memberBase1 = new MemberBase();
        memberBase1.setId(memberBase.getId());
        memberBase1.setPassword(Md5Utils.md5(changePwdDto.getNewpwd()));
//        QueryWrapper<MemberBase> wrapper = new QueryWrapper<>();
//        wrapper.eq("id",memberBase.getId());

        // int update = memberBaseMapper.update(memberBase1, wrapper);
        int update = memberBaseMapper.updateById(memberBase1);
        return update>0;
    }

    @Override
    public MemberBase getLoginedUser() {

        return memberBaseMapper.getUserByToken(request.getHeader("token"));
    }

    @Override
    public void getUserList(UserListQueryParam userListQueryParam, Result result) {
        Page<MemberBase> page = new Page<>(userListQueryParam.getPageNum(), PageConfig.pageSize);

        QueryWrapper<MemberBase> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        memberBaseMapper.selectPage(page,wrapper);

        PageListVo<MemberBase> pageListVo = PageUtils.createPage(page);

        result.setData(pageListVo);
    }

    @Override
    public MemberBase getUserByPhone(String phone) {
        return memberBaseMapper.getUserByPhone(phone);
    }

    @Override
    public MemberBase getUserByusername(String username) {
        return memberBaseMapper.getUserByUsername(username);
    }

    @Override
    public boolean updateUserinfo(MemberBase memberBase) {

        int i = memberBaseMapper.updateById(memberBase);
        return i>0;
    }



}
