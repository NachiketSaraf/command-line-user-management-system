package com.bootcoding.user.command.imp;

import com.bootcoding.user.command.Command;
import com.bootcoding.user.command.validator.CommandValidator;
import com.bootcoding.user.model.Result;

public class CreateCommand implements Command, CommandValidator {
    @Override
    public Result execute(String[] attributes) throws Exception {
        return null;
    }

    @Override
    public boolean validate(String[] attributes) throws Exception {
        return false;
    }
}
