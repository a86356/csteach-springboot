package com.csteach.teachproject.common.lang;

import com.csteach.teachproject.common.constants.ResultCode;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@Data
public class Result implements Serializable {

    private Integer code; //
    private String msg;  //结果消息
    private Object data; //返回数据
    private String status; //状态信息

    public Result(){}


    public void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }

    public Map<String, Object> simple() {

        Map<String, Object> simple = new HashMap<String, Object>();
        this.data = simple;
        
        return simple;
    }


    public static Result success(int code, String msg, Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        result.setStatus("success");
        return result;
    }
    public static Result success(Object data){
        return success(0,"成功",data);
    }


    public static Result success(){
        return success(0,"成功",null);
    }



    public static Result fail(String msg){
        return fail(400,msg,null);
    }


    public static Result fail(int code, String msg, Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        result.setStatus("fail");
        return result;
    }

}
