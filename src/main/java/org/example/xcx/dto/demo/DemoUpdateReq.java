package org.example.xcx.dto.demo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
public class DemoUpdateReq {
    @Min(1)
    @NotNull(message = "id不能为空")
    Long id;
    @NotEmpty(message = "用户名不能为空")
    String name;
    @NotNull(message = "年龄不能为空")
    Integer age;
}
