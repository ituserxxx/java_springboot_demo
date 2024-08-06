package org.example.xcx.dto.demo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class DemoGetOneReq {
    @Min(1)
    @NotNull(message = "id不能为空")
    Long id;
}
