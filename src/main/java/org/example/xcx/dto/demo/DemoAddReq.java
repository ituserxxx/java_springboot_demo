package org.example.xcx.dto.demo;

import lombok.Data;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class DemoAddReq {
    String a1;
    @NotEmpty(message = "用户名不能为空")
    String name;
    @NotNull(message = "年龄不能为空")
    Integer age;
}
