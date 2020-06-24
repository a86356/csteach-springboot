package com.csteach.teachproject.service;

import com.aliyuncs.exceptions.ClientException;
import org.springframework.stereotype.Service;

@Service
public interface SmsService {

    public void SendSms(String phone,String code) throws ClientException;
    public void SendSms(String phone) throws ClientException;
}
