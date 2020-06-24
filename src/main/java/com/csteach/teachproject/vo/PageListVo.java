package com.csteach.teachproject.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageListVo<T> {
    private long total;
    private long size;
    private long current;
    private long pages;
    private List<T> list;

}
