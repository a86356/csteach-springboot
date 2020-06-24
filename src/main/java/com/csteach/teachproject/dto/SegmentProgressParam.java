package com.csteach.teachproject.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class SegmentProgressParam {

    @NotNull
    private long classId;


    @NotNull
    private long segId;

}
