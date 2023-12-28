package com.bootcoding.user.command.validator;

public interface CommandValidator {
    public boolean validate(String[] attributes) throws Exception;
}
