package com.csteach.teachproject.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PageParam {

    @NotNull
    private long pageNum;
}
