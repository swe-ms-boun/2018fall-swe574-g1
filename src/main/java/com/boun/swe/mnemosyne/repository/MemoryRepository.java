package com.boun.swe.mnemosyne.repository;

import com.boun.swe.mnemosyne.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryRepository extends JpaRepository<User, Long> {

    //List<Memory> findMemoriesByTitle(String title);

    //List<Memory> findMemoriesByUsername(String userName);

    //List<Memory> findMemoriesByLocation(String location);

    //List<Memory> findMemoriesByArea(Area area);

}
