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
public class LoginDto {

    @NotEmpty(message = "用户名不能为空")
    @NotNull
    private String username;


    @NotEmpty(message = "密码不能为空")
    @NotNull
    private String password;

//    @CheckPhone
//    private String phone;


}
