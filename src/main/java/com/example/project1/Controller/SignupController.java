package com.example.project1.Controller;

import com.example.project1.dto.UserDto;
import com.example.project1.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignupController {

    private final TaskService taskService;
    @GetMapping
    public String signup(){
        return "tasks/signup";
    }

    @PostMapping
    public String register(@Validated UserDto dto,
                           @RequestParam String confirmPassword,
                           Model model,
                           RedirectAttributes redirectAttributes) {
        String msg = taskService.registerUser(dto, confirmPassword);

        if (msg.equals("1")){
            model.addAttribute("msg", "아이디가 중복됩니다.");
            return "tasks/signup";
        }
        else if (msg.equals("2")) {
            model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
            return "tasks/signup";
        }
        else {
            redirectAttributes.addFlashAttribute("msg3", "회원가입에 성공하였습니다.");
            return "redirect:/login";
        }
    }
}
