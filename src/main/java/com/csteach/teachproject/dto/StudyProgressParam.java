package com.csteach.teachproject.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class StudyProgressParam {

    @NotNull
    private long pageNum;


    @NotNull
    private String nickName;
}
