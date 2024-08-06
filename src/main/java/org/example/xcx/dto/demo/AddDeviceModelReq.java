package org.example.xcx.dto.demo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AddDeviceModelReq {
    String deviceName;
    String deviceModel;
    MultipartFile file;
}
