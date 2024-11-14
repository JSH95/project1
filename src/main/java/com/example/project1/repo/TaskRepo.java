package com.example.project1.repo;


import com.example.project1.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepo extends JpaRepository<UserDto, Long> {
    Optional<UserDto> findByIdAndPassword(String id, String password);
    boolean existsById(String id);
}
