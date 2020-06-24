package com.csteach.teachproject.dto;


import com.csteach.teachproject.common.validation.CheckEmail;
import com.csteach.teachproject.common.validation.CheckPhone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendSmsDto {


    @NotEmpty(message = "手机号不能为空")
    @CheckPhone
    private String phone;


    @NotEmpty(message = "类型不能为空")
    private String type;
}
