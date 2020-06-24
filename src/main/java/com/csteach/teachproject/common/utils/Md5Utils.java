package com.csteach.teachproject.common.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
@Component
public class Md5Utils {

    public static String md5(String value){
        return DigestUtils.md5DigestAsHex(value.getBytes());
    }

}
