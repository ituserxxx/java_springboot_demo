package org.example.xcx.validtion;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotSpaceValition implements ConstraintValidator<NotSpace,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.contains(" ")){
            return false;
        }
        return true;
    }
}
