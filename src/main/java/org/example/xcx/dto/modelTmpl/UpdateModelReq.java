package org.example.xcx.dto.modelTmpl;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

@Data
public class UpdateModelReq {
    Integer id;
    @NotEmpty(message = "设备名称不能为空")
    String deviceName;
    @NotEmpty(message = "设备型号不能为空")
    String deviceModel;
    MultipartFile file;
}
