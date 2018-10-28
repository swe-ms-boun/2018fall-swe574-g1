package com.boun.swe.mnemosyne.controller;

import com.boun.swe.mnemosyne.model.Memory;
import com.boun.swe.mnemosyne.model.User;
import com.boun.swe.mnemosyne.service.SecurityService;
import com.boun.swe.mnemosyne.service.UserService;
import com.boun.swe.mnemosyne.validator.UserValidator;
import org.h2.api.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.websocket.Session;
import java.util.List;

@Controller
public class MemoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemoryController.class);

    private UserService userService;
    private SecurityService securityService;
    private UserValidator userValidator;

    @Autowired
    public MemoryController(final UserService userService, final SecurityService securityService, final UserValidator userValidator) {
        this.userService = userService;
        this.securityService = securityService;
        this.userValidator = userValidator;
    }

    public List<Memory> getMemoriesOfUser(String userName) throws UserNotFoundException
    {
        User searchResult;
        try{
            searchResult = userService.findByUsername(userName);
        }catch (Exception ex)
        {
            throw new UserNotFoundException("There us not found", ex, ErrorCode.USER_OR_ROLE_NOT_FOUND_1);
        }

        return null;
    }
}

class UserNotFoundException extends Exception {

    private final int code;

    public UserNotFoundException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }
}
