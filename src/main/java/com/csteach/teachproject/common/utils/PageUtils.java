package com.csteach.teachproject.common.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csteach.teachproject.common.config.PageConfig;
import com.csteach.teachproject.entity.MemberCheckin;
import com.csteach.teachproject.vo.PageListVo;
import lombok.Data;

import java.util.List;

@Data
public class PageUtils {

    public static <T> PageListVo<T> createPage(Page page){
        PageListVo<T> objectPageListVo = new PageListVo<>();
        CopyUtils.copyObj(page,objectPageListVo);
        objectPageListVo.setList(page.getRecords());
        return  objectPageListVo;
    }
}
