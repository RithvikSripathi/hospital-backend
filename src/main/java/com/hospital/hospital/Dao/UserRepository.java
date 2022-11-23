package com.hospital.hospital.Dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.hospital.entities.User;
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);

}


