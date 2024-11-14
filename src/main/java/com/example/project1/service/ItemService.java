package com.example.project1.service;

import com.example.project1.dto.ItemDto;
import com.example.project1.dto.UserDto;
import com.example.project1.repo.ItemRepo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepo itemRepo;
    private final HttpSession session;

    public List<ItemDto> getAllItems() {
        UserDto dto = (UserDto) session.getAttribute("user");
        String userid = dto.getId();
        return itemRepo.findByUserid(userid);
    }
}
