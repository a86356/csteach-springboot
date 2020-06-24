package com.csteach.teachproject.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserQueryParam {

    @NotEmpty(message = "type不能为空")
    @NotNull
    private String type;

    @NotEmpty(message = "value不能为空")
    @NotNull
    private String value;
}
