package com.csteach.teachproject.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
public class CheckinQueryParam {

    @NotNull
    private long pagenum;


    @NotEmpty(message = "昵称不能为空")
    @NotNull
    private String nickname;


}
