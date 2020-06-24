package com.csteach.teachproject.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class SaveUserInfoDto {

    @NotEmpty(message = "github不能为空")
    @NotNull
    private String github;

    @NotEmpty(message = "公司名不能为空")
    @NotNull
    private String company;

    @NotEmpty(message = "职位不能为空")
    @NotNull
    private String position;

    @NotEmpty(message = "头像不能为空")
    @NotNull
    private String avatarUrl;
    // a_b_c
    // aBC

}
