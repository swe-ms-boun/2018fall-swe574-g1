package com.boun.swe.mnemosyne.service;

import com.boun.swe.mnemosyne.model.Memory;
import com.boun.swe.mnemosyne.model.User;
import com.boun.swe.mnemosyne.model.dto.MemoryDto;
import com.boun.swe.mnemosyne.repository.MemoryRepository;
import com.boun.swe.mnemosyne.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemoryService.class);

    private MemoryRepository memoryRepository;
    private UserRepository userRepository;

    @Autowired
    public MemoryService(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    public Memory createMemory(final String username, final MemoryDto memoryDto) {
        final User user = userRepository.findByUsername(username);
        final Memory memory = convertMemoryDtoToMemoryEntity(memoryDto);
        memory.setUser(user);
        return memoryRepository.save(memory);
    }

    public List<Memory> getMemories(final String username) {
        final User user = userRepository.findByUsername(username);
        return memoryRepository.findMemoriesByUserId(user.getId());
    }

    // TODO : move converter class
    public Memory convertMemoryDtoToMemoryEntity(final MemoryDto memoryDto) {
        return new Memory();
    }
}
