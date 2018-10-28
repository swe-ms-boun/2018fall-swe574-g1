package com.boun.swe.mnemosyne.service;

import com.boun.swe.mnemosyne.enums.Role;
import com.boun.swe.mnemosyne.model.User;
import com.boun.swe.mnemosyne.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemoryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MemoryService.class);


    @Autowired
    public MemoryService() {

    }



}
