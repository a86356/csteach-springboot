package com.csteach.teachproject.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csteach.teachproject.common.utils.RandomUtils;
import com.csteach.teachproject.common.utils.SmsUtils;
import com.csteach.teachproject.entity.MemberCode;
import com.csteach.teachproject.mapper.MemberCodeMapper;
import com.csteach.teachproject.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private SmsUtils smsUtils;

    @Autowired
    private MemberCodeMapper memberCodeMapper;

    @Autowired
    private RandomUtils randomUtils;


    @Override
    public void SendSms(String phone) throws ClientException {
        SendSms(phone,randomUtils.getRandomNumber(6));
    }


    @Override
    public void SendSms(String phone, String code) throws ClientException {

        QueryWrapper<MemberCode> wrapper = new QueryWrapper<>();
        wrapper.eq("phone",phone);
        MemberCode memberCode = memberCodeMapper.selectOne(wrapper);

        //验证一个手机号码只能发送一次短信
        //Assert.isNull(memberCode,"这个手机号码已经发过短信了");


        MemberCode memberCode1 = new MemberCode();
        memberCode1.setPhone(phone);
        memberCode1.setType(1);

        memberCodeMapper.insert(memberCode1);

        //发送短信
    //    smsUtils.sendSms(phone,code);


    }
}
