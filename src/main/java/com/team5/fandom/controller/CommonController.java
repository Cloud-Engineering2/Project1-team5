package com.team5.fandom.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.team5.fandom.controller.rto.request.RegistryRequest;
import com.team5.fandom.dto.FandomDto;
import com.team5.fandom.dto.UserDto;
import com.team5.fandom.service.CommonService;
import com.team5.fandom.service.FandomService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CommonController {
    private final CommonService commonService;
    private final FandomService fandomService;
    private final PasswordEncoder passwordEncoder; // 의존성 주입
    
    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("pageTitle", "Login");
        return "login";
    }
//
//    @PostMapping("/login")
//    public String formLogin(
//            @RequestParam("id") String email,
//            @RequestParam("password") String password,
//            HttpServletRequest request,
//            Model model) {
//        
//        // 사용자 인증 처리
//        UserDto user = commonService.authenticate(email, password);
//
//        if (user != null) {
//            // 인증 성공 시 세션 생성
//            HttpSession session = request.getSession();
//            session.setAttribute("userId", user.getUserId());
//
//            return "redirect:/"; 
//        } else {
//            // 인증 실패 시 에러 메시지와 함께 로그인 페이지로 이동
//            model.addAttribute("error", "Invalid Email or password");
//            return "login";
//        }
//    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        RegistryRequest regReq = new RegistryRequest(); // 객체 생성
        List<FandomDto> fandoms = fandomService.getAllFandoms();
        model.addAttribute("fandoms", fandoms);
        model.addAttribute("regReq", regReq); // Model에 추가
        model.addAttribute("validationErrors", new HashMap<String, String>()); // 초기 validationErrors 추가
        return "register";
    }
    
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute RegistryRequest regReq, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<FandomDto> fandoms = fandomService.getAllFandoms();
            model.addAttribute("fandoms", fandoms);
            model.addAttribute("regReq", regReq);

            Map<String, String> validationErrors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> 
                validationErrors.put(error.getField(), error.getDefaultMessage())
            );
            model.addAttribute("validationErrors", validationErrors);
            model.addAttribute("errorMessage", "회원가입에 실패하였습니다.");
            return "register";
        }

        try {
            UserDto userDto = UserDto.builder()
                .userName(regReq.getUserName())
                .password(passwordEncoder.encode(regReq.getPassword())) // 암호화 적용
                .email(regReq.getEmail())
                .fandomDto(fandomService.getByFandomName(regReq.getFandomName()))
                .build();

            commonService.registerUser(userDto);
        } catch (IllegalArgumentException e) {
            List<FandomDto> fandoms = fandomService.getAllFandoms();
            model.addAttribute("fandoms", fandoms);
            model.addAttribute("regReq", regReq);
            model.addAttribute("errorMessage", e.getMessage());
            return "register";
        }

        return "redirect:/";
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login"; // 로그아웃 후 로그인 페이지로 이동
    }
}
