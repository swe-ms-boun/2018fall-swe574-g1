package com.boun.swe.mnemosyne.service;

import com.boun.swe.mnemosyne.model.Memory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemoryService.class);

    public List<Memory> getMemories(String username) {
        return null;
    }
}
