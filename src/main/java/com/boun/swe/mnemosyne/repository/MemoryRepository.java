package com.boun.swe.mnemosyne.repository;

<<<<<<< HEAD
import com.boun.swe.mnemosyne.model.Memory;
=======
>>>>>>> dc204bc30ff96b8fc3a27fdad67652dee7309dce
import com.boun.swe.mnemosyne.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryRepository extends JpaRepository<Memory, Long> {

    //List<Memory> findMemoriesByTitle(String title);

    List<Memory> findMemoriesByUsername(String userName);

    //List<Memory> findMemoriesByLocation(String location);

    //List<Memory> findMemoriesByArea(Area area);

}
