package com.csteach.teachproject.controller;

import com.aliyuncs.exceptions.ClientException;
import com.csteach.teachproject.common.utils.SmsUtils;
import com.csteach.teachproject.dto.RegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@Validated
public class IndexController {

    @Autowired
    private SmsUtils smsUtils;


    @GetMapping("/test")
    public Object test(@RequestBody @Valid RegisterDto registerDto) throws ClientException {
        smsUtils.sendSms("18658771300","123221");



        return "112233";
    }

}
