package com.example.project1.Controller;

import com.example.project1.dto.ItemDto;
import com.example.project1.dto.UserDto;
import com.example.project1.service.ItemService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;
    private final HttpSession session;

    @GetMapping
    public String list(Model model){


        List<ItemDto> items = itemService.getAllItems();
        model.addAttribute("items", items);
        return "tasks/list";

    }
}
