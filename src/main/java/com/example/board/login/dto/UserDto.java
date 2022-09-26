package com.example.board.login.dto;

import com.example.board.exception.AdminValidGroup;
import com.example.board.exception.UserValidGroup;
import com.example.board.login.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class UserDto {
    @NotBlank(groups = {UserValidGroup.class, AdminValidGroup.class}, message = "아이디를 입력해주세요.")
    @Pattern(groups = {UserValidGroup.class, AdminValidGroup.class}, regexp = "^[a-zA-Z0-9]{2,10}$", message = "아이디는 영문과 숫자만 입력해 주세요.")
    String username;

    @NotBlank(groups = {UserValidGroup.class, AdminValidGroup.class}, message = "비밀번호를 입력해주세요.")
    @Pattern(groups = {UserValidGroup.class, AdminValidGroup.class}, regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,10}$", message = "비밀번호는 영문/숫자를 포함해 6~10자로 입력해 주세요.")
    String password;

    User.UserRole userRole;

    @NotNull(groups = UserValidGroup.class, message = "올바른 bizcode를 입력해주세요.")
    Integer bizcode;
}
