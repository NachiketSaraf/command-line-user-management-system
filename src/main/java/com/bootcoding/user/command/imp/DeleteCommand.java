package com.bootcoding.user.command.imp;

import com.bootcoding.user.command.Command;
import com.bootcoding.user.command.validator.CommandValidator;
import com.bootcoding.user.model.Result;
import com.bootcoding.user.model.User;
import com.bootcoding.user.store.InMemoryStore;

public class DeleteCommand implements Command, CommandValidator {
    @Override
    public Result execute(String[] attributes) throws Exception {
        if (validate(attributes)) {
            switch (attributes[1]) {
                case "-i":
                    return deleteById(attributes[2]);

            }
        }
        return Result.builder().message("Invalid read command arguments").build();
    }

    private Result deleteById(String id) {
        User u = InMemoryStore.userList
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .get();
        InMemoryStore.userList.remove(u);

        return Result.builder().message("DELETED SUCCESS").build();
    }


    @Override
    public boolean validate(String[] attributes) throws Exception {
        if (attributes.length != 3) {
            throw new Exception("Please provide name : " +
                    "For ex: \ndelete --id \"userId\" ");
        }
        if (!attributes[1].equals("-i")) {
            throw new Exception("Please provide in this format : " +
                    "For ex: \ndelete --id \"userId\" ");

        }
        return false;
    }
}
