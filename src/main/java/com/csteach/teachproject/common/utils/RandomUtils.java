package com.csteach.teachproject.common.utils;


import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomUtils {

    /**
     * 获得随机数的方法
     * @param number 需要获得几个随机数
     * @return
     */
    public String getRandomNumber(int number){
        String str="0123456789";
        return getRandomString(number,str);
    }

    /**
     * 获得随机数字，包含数字，大写字母，小写字母
     * @param number
     * @return
     */
    public String getRandomNumAndEnglish(int number){
        String str="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return getRandomString(number,str);
    }



    /**
     * 获得随机的字符串
     * @param number 表示要获得几位数
     * @param scope 随机数的范围
     * @return
     */
    protected String getRandomString(int number,String scope){
        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0;i<number;i++){
            int j = getRandom(0,scope.length()-1);
            stringBuilder.append(scope.charAt(j));
        }
        return stringBuilder.toString();
    }

    /**
     * 获得[min,max]的随机数  【1-10】
     * @param min 最小值,包含
     * @param max 最大值,包含
     * @return
     * https://blog.csdn.net/dhklsl/article/details/80647950
     */
    protected Integer getRandom(int min, int max){
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;
        //return String.valueOf(s);
    }
}
