package com.csteach.teachproject.vo;

import com.csteach.teachproject.common.config.PageConfig;
import lombok.Data;

import java.util.List;

@Data
public class ListVo<T> {

    private long pageNum;
    private long pageSize = PageConfig.pageSize;
    private long total;

    private List<T> list;

}
