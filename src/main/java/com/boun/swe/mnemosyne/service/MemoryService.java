package com.boun.swe.mnemosyne.service;

import com.boun.swe.mnemosyne.model.Memory;
import com.boun.swe.mnemosyne.model.User;
import com.boun.swe.mnemosyne.model.dto.MemoryDto;
import com.boun.swe.mnemosyne.repository.MemoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.management.MemoryPoolMXBean;
import java.util.List;

@Service
public class MemoryService {

    private MemoryRepository memoryRepository;

    @Autowired
    public MemoryService(MemoryRepository memoryRepository) {

        this.memoryRepository = memoryRepository;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MemoryService.class);

    public List<Memory> getMemories(String username) {
        return memoryRepository.findMemoriesByUsername(username);
    }

    public Memory setMemoryFields(Memory orgin, MemoryDto memoryDto, User user)
    {
        orgin.setUser(user);
        orgin.setDateFrom(memoryDto.getDateFrom());
        orgin.setDateTo(memoryDto.getDateTo());
        orgin.setLocations(memoryDto.getLocations());
        orgin.setPublic(memoryDto.isPublic());
        orgin.setPublished(memoryDto.isPublished());
        orgin.setText(memoryDto.getText());
        orgin.setTitle(memoryDto.getTitle());
        return orgin;
    }

    public boolean isMemoryExist(Long id)
    {
        Memory memo = memoryRepository.findOne(id);

        if (memo != null)
            return true;
        else
            return false;
    }

    public Memory getMemoryById(Long id)
    {
        return memoryRepository.getOne(id);
    }
}
