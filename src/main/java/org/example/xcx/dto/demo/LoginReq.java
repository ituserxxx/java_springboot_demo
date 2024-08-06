package org.example.xcx.dto.demo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginReq {
    @NotEmpty(message = "用户名不能为空")
    String userName;
    @NotEmpty(message = "密码不能为空")
    String password;
}
