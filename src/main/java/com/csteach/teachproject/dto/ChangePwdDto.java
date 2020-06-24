package com.csteach.teachproject.dto;


import com.csteach.teachproject.common.validation.CheckEmail;
import com.csteach.teachproject.common.validation.CheckPhone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePwdDto {

    @NotEmpty(message = "新密码不能微控")
    @NotNull
    private String newpwd;


    @NotEmpty(message = "旧密码不能微控")
    @NotNull
    private String oldpwd;

}
