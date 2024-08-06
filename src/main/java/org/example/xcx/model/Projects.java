package org.example.xcx.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("projects")
public class Projects {

    private Long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private String mainGatewayId;

    private String name;

    private String creatorId;

    private String wallpaperId;

    private String cameraMainId;

    private String address;

    private String province;

    private String city;

    private String region;
}