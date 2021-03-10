package org.geektimes.projects.user.validator.bean.validation;

import org.geektimes.projects.user.domain.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.regex.Pattern;

public class UserValidAnnotationValidator implements ConstraintValidator<UserValid, User> {

    private int idMinValue;

    private int passwordMinLen;

    private int passwordMaxLen;

    private String phoneRegx;

    private Class<?>[] groups;

    private String message;

    @Override
    public void initialize(UserValid annotation) {
        this.idMinValue = annotation.idMinValue();
        this.passwordMinLen = annotation.passwordMinLen();
        this.passwordMaxLen = annotation.passwordMaxLen();
        this.phoneRegx = annotation.phoneRegx();
        this.groups = annotation.groups();
        this.message = annotation.message();
    }

    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {
        String password = value.getPassword();
        String phoneNumber = value.getPhoneNumber();

        boolean result = true;
        StringBuilder errorMsg = new StringBuilder();

        if (Objects.isNull(password) || password.length() < passwordMinLen || password.length() > passwordMaxLen) {
            errorMsg.append("password长度必须大于").append(passwordMinLen).append("并且小于").append(passwordMaxLen).append(";");
            result =  false;
        }

        if (!Pattern.matches(phoneRegx, phoneNumber)) {
            errorMsg.append("电话号码格式错误");
            result =  false;
        }

        if (Objects.nonNull(message) && !"".equals(message)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorMsg.toString()).addConstraintViolation();
        }

        return result;
    }
}
