package com.example.project1.service;

import com.example.project1.dto.UserDto;
import com.example.project1.repo.TaskRepo;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepo taskRepo;
    private final HttpSession session;

    public boolean login(UserDto dto) {

        Optional<UserDto> result = taskRepo.findByIdAndPassword(dto.getId(), dto.getPassword());
        boolean loginS;
        if (result.isEmpty()){
            loginS = false;
        } else{
            session.setAttribute("user", result.get());
            loginS = true;
        }
        return loginS;
    }

    @Transactional
    public String registerUser(UserDto dto, String confirmPassword) {
        if (taskRepo.existsById(dto.getId())) {
            return "1";
        }

        if (!dto.getPassword().equals(confirmPassword)) {
            return "2";
        }

        taskRepo.save(dto);
        return "3";
    }

}
