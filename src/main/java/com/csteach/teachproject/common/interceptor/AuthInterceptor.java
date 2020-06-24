package com.csteach.teachproject.common.interceptor;

import com.csteach.teachproject.common.exception.CommonException;
import com.csteach.teachproject.common.lang.Result;
import com.csteach.teachproject.entity.MemberBase;
import com.csteach.teachproject.mapper.MemberBaseMapper;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private MemberBaseMapper memberBaseMapper;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    //  System.out.println("preHandle...");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");
        response.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
        //浏览器会先发送一个试探请求OPTIONS,然后才会发送真正的请求，为了避免拦截器拦截两次请求，所以不能让OPTIONS请求通过
        if ("OPTIONS".equals(request.getRequestURI())){
            return false;
        }

        //token 验证
        String token = request.getHeader("token");
        if(token==null){
             throw new CommonException("用户未登录");
        }

        MemberBase userByToken = memberBaseMapper.getUserByToken(token);

        if(userByToken==null){
            throw new CommonException("密钥失效，请重新登录");
        }

        return true;
    }



}
