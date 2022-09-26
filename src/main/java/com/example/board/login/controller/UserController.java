package com.example.board.login.controller;

import com.example.board.exception.AdminValidGroup;
import com.example.board.exception.UserValidGroup;
import com.example.board.login.dto.UserDto;
import com.example.board.login.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 관리자
    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "admin";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user() {
        return "user";
    }
//    , produces = "application/json; charset=utf8"

    // 관리자
    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<String> adminSignup(
            @Validated(AdminValidGroup.class) @RequestBody UserDto userDto, BindingResult bindingResult) {
        return userService.adminSignup(userDto, bindingResult);
    }

    // 관리자가 User 가입
    @PostMapping("/admin/signup")
    @ResponseBody
    public ResponseEntity<String> userSignup(
            @Validated(UserValidGroup.class) @RequestBody UserDto userDto, BindingResult bindingResult) {
        return userService.userSignup(userDto, bindingResult);
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> login(@Validated @RequestBody UserDto userDto) {
        return userService.login(userDto);
    }
}
