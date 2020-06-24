package com.csteach.teachproject.common.validation.validator;

import com.csteach.teachproject.common.validation.CheckEmail;
import com.csteach.teachproject.common.validation.CheckPhone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckEmailConstraintValidator implements ConstraintValidator<CheckEmail, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        boolean isMatch = m.matches();
        if(isMatch){
            return true;
        }
        return false;

    }
}
