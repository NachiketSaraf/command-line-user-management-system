package com.bootcoding.user.command.imp;

import com.bootcoding.user.command.Command;
import com.bootcoding.user.command.validator.CommandValidator;
import com.bootcoding.user.model.Result;
import com.bootcoding.user.model.User;
import com.bootcoding.user.util.ValidationUtility;
import com.bootcoding.user.store.InMemoryStore;

import java.util.Random;
import java.util.UUID;

public class CreateCommand implements Command, CommandValidator {
    @Override
    public Result execute(String[] attributes) throws Exception {
        if (validate(attributes)) {
            User user = createUser(attributes);
            InMemoryStore.userList.add(user);
            return Result.builder().message("SUCCESS").userList(InMemoryStore.userList).build();
        }
        return Result.builder().message("Invalid create command arguments").build();
    }

    private User createUser(String[] attributes) throws Exception{
        Random random = new Random();
        User user = User.builder()
                .id(String.valueOf(random.nextInt(0000,9999)))
                .build();
        for(int i = 1; i < attributes.length ; i = i + 2) {
            String attrName = attributes[i];
            setUserAttributeValue(user, attrName, attributes[i + 1]);
        }
        return user;
    }

    private void setUserAttributeValue(User user, String attrName, String value) {
        switch (attrName){
            case "-n" :
                user.setName(value);
                break;
            case "-a" :
                user.setAddress(value);
                break;
            case "-e" :
                user.setEmailId(value);
                break;
            case "-p" :
                user.setPhone(Long.parseLong(value));
                break;
        }
    }

    @Override
    public boolean validate(String[] attributes) throws Exception {
        if (attributes.length != 9) {
            throw new Exception("Please provide all attributes: " +
                    "For ex: \ncreate -n \"name\" -p 987654321 -a " +
                    "\"Nagpur\" -e \"emailname@gmail.com\"");
        }

        boolean isValid = true;
        int i = 1;
        while (isValid && i < attributes.length) {
            String attrName = attributes[i];
            isValid = ValidationUtility.validateAttributes(attrName);
            i = i + 2;
        }

        return isValid;
    }
}
