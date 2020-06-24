package com.csteach.teachproject.common.myassert;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


public class MyAssert {

    public static void ifNull(Object object,String msg){
        Assert.notNull(object,msg);
    }

    public static void ifNotNull(Object object,String msg){
        Assert.isNull(object,msg);
    }
}
