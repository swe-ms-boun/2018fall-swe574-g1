package com.boun.swe.mnemosyne.controller;

import com.boun.swe.mnemosyne.exception.UserNotFoundException;
import com.boun.swe.mnemosyne.model.Memory;
import com.boun.swe.mnemosyne.model.User;
import com.boun.swe.mnemosyne.model.dto.MemoryDto;
import com.boun.swe.mnemosyne.service.MemoryService;
import com.boun.swe.mnemosyne.service.UserService;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;

@Controller
public class MemoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemoryController.class);

    private UserService userService;
    private MemoryService memoryService;

    @Autowired
    public MemoryController(final UserService userService, final MemoryService memoryService) {
        this.userService = userService;
        this.memoryService = memoryService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Memory> getMemoriesOfUser(String username) throws UserNotFoundException {
        LOGGER.info("Get memories request with username '{}' received", username);
        final User user = userService.findByUsername(username);
        if (Objects.isNull(user)) {
            final String errorMsg = String.format("User with username '%s' not found", username);
            throw new UserNotFoundException(errorMsg);
        }
        return memoryService.getMemories(username);
    }

    public Memory createNewMemories(@ModelAttribute("memoryForm") final Memory memory, User user)
    {
        memory.setUser(user);
        return memory;
    }

    public Memory editExistingMemory(@ModelAttribute("memoryForm") final MemoryDto memoryDto, User user, long memoryId) throws ObjectNotFoundException
    {
         Memory memo;

         if(!memoryService.isMemoryExist(memoryId)){
             throw new ObjectNotFoundException("MemoryNotFound","Memory item could not found");
         }else{
            memo = memoryService.getMemoryById(memoryId);
         }
         memoryService.setMemoryFields(memo, memoryDto, user);

         return memo;
    }




}