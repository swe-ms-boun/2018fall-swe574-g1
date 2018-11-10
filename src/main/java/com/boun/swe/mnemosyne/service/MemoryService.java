package com.boun.swe.mnemosyne.service;

import com.boun.swe.mnemosyne.model.Memory;
import com.boun.swe.mnemosyne.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class MemoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemoryService.class);

    public List<Memory> getMemories(String username) {
        return null;
    }

    public Memory createNewMemories(User user)
    {
        Memory newMemo = new Memory();

    }

    public void setMemory(@ModelAttribute("userForm") final Memory UserForm, User user)
    {
        memory.setUser(user);
        memory.setDateFrom();
    }
}
