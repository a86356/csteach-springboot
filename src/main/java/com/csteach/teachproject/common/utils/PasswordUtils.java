package com.csteach.teachproject.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtils {

    @Autowired
    private Md5Utils md5Utils;

    public String encode(String rawPassword) {
        return md5Utils.md5(rawPassword);
    }

    public boolean matches(String rawPassword, String encodedPassword) {
        return encodedPassword.equals(md5Utils.md5(rawPassword));
    }
}
