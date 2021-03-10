package org.geektimes.projects.user.validation;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Pattern;

/**
 * 手机号验证器
 *
 * @author chensc
 * @date 2021/3/9 16:20
 */
public class PhoneValidAnnotationValidator implements ConstraintValidator<PhoneValid, String> {

    @Override
    public void initialize(PhoneValid phoneValid) {

    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(phone)) {
            return false;
        }

        return phone.matches("^^1[1-9]\\d{9}$");
    }
}
