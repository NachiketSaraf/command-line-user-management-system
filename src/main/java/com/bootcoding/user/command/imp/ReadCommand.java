package com.bootcoding.user.command.imp;

import com.bootcoding.user.command.Command;
import com.bootcoding.user.command.validator.CommandValidator;
import com.bootcoding.user.model.Result;
import com.bootcoding.user.store.InMemoryStore;
import com.bootcoding.user.model.User;

import java.util.ArrayList;
import java.util.List;

public class ReadCommand implements Command, CommandValidator {
    @Override
    public Result execute(String[] attributes) throws Exception {
        if (validate(attributes)) {
            switch (attributes[1]) {
                case "-n":
                    return readByName(attributes[2]);
                case "-i":
                    return readById(attributes[2]);
                case "-all":
                    return readAll();
            }
        }
        return Result.builder().message("Invalid read command arguments").build();
    }

    private Result readByName(String name) {
        List<User> ansList = new ArrayList<>();
        List<User> ul = InMemoryStore.userList;
        for (User user : ul) {
            if (user.getName().equals(name)){
                ansList.add(user);
            }
        }
        if (!ansList.isEmpty()) return Result.builder()
                .message("SUCCESS")
                .userList(ansList)
                .build();

        return Result.builder().message("FAILED: User name (" + name + ") doesn't exists!").build();
    }

    private Result readAll() {
        return Result.builder().message("SUCCESS")
                .userList(InMemoryStore.userList).build();
    }
    private Result readById(String id) {
        List<User> ul = InMemoryStore.userList;
        for (User user :ul) {
            if (user.getId().equals(id)) {
                return Result.builder()
                        .message("SUCCESS")
                        .userList(List.of(user))
                        .build();
            }
        }
        return Result.builder().message("FAILED: User Id (" + id + ") doesn't exists!").build();
    }

    @Override
    public boolean validate(String[] attributes) throws Exception {
        if (attributes.length != 3) {
            throw new Exception("Please provide name : " +
                    "For ex: \nread -n \"name\" ");
        }
        return true;
    }
}
