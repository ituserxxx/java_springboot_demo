package org.example.xcx.dto.AdminUser;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginReq {
    @NotEmpty(message = "手机号不能为空")
    private String phone;
    @NotEmpty(message = "密码不能为空")
    private String password;
    public class AddAdminReq {
        @NotEmpty(message = "手机号不能为空")
        private String phone;
        @NotEmpty(message = "密码不能为空")
        private String password;
    }

}


