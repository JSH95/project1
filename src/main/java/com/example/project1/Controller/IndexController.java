package com.example.project1.Controller;

import com.example.project1.dto.UserDto;
import com.example.project1.service.TaskService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class IndexController {

    private final TaskService taskService;
    private final HttpSession session;
    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("login")
    public String getLogin() {
        return "tasks/login";
    }
    @PostMapping("login")
    public String postLogin(@Validated UserDto dto){
        Boolean A = taskService.login(dto);
        if(A == true){
            return "index";
        } else {
            return "tasks/login";
        }
    }

    @PostMapping("logout")
        public String logOut(){
        session.invalidate();
        return "redirect:/";
    }

}
