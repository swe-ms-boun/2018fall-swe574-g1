package com.boun.swe.mnemosyne.repository;

import com.boun.swe.mnemosyne.model.Memory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemoryRepository extends JpaRepository<Memory, Long> {

    List<Memory> findMemoriesByTitle(String title);

    // TODO : Update the query
    @Query("SELECT m FROM Memory m WHERE m.user.id = ?1")
    List<Memory> findMemoriesByUserId(long userId);
}
