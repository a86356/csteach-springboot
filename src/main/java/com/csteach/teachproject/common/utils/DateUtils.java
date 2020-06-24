package com.csteach.teachproject.common.utils;

import org.springframework.stereotype.Component;

@Component
public class DateUtils {

    //获得10位数的时间戳
    public long get10Time(){
        return System.currentTimeMillis()/1000;
    }




}
