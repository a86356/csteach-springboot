package com.csteach.teachproject.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserListQueryParam {

    @NotNull
    private long pageNum;

}
