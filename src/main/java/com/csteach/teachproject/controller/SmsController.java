package com.csteach.teachproject.controller;


import com.aliyuncs.exceptions.ClientException;
import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.common.utils.SmsUtils;
import com.csteach.teachproject.dto.SendSmsDto;
import com.csteach.teachproject.mapper.AdminBaseMapper;
import com.csteach.teachproject.service.impl.SmsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
public class SmsController {

    @Autowired
    private SmsUtils smsUtils;

    @Autowired
    private SmsServiceImpl smsService;

    @Autowired
    private AdminBaseMapper mapper;

    @PostMapping ("/sendcode")
    public Object sendcode(@RequestBody @Valid  SendSmsDto sendSmsDto) throws ClientException {
        smsService.SendSms(sendSmsDto.getPhone());

        return Result.success();
    }

}
