package org.example.xcx.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Time;

@TableName("admin_user")
@Data
public class AdminUser {
    @TableId
    private Integer id;
    @NotNull(message = "手机号不能为空")
    private String phone;
    @NotNull(message = "密码不能为空")
    private String password;
    private Time createdTime;
}
