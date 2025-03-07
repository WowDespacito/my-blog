package com.wowdespacito.my_blog.validation;

import java.util.Arrays;
import java.util.List;

import com.wowdespacito.my_blog.anno.Status;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StatusValidation implements ConstraintValidator<Status, Integer> {
    /*
     * @param value 需要校验的值
     * @param context 上下文
     * @return boolean
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // 校验规则
        if (value == null) {
            return false;
        }
        List<Integer> statusList = Arrays.asList(-1, 0, 1);
        if (!statusList.contains(value)) {
            return false;
        }
        return true;
    }
    
}
