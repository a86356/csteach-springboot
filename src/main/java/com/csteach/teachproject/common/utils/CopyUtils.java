package com.csteach.teachproject.common.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class CopyUtils {

    /**
     *
     * @param src
     * @param desc
     */
    public static void copyObj(Object src,Object desc) {

        BeanUtils.copyProperties(src, desc);
    }

    public static  <T,Vo>  void copyList(List<T> src,List<Vo> desc, Class<Vo> vo) {
        
        try {
            for (int i=0;i<src.size();i++){
                Vo vo1 = vo.newInstance();

                copyObj(src.get(i),vo1);
                desc.add(vo1);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}