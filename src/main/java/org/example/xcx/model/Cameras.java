package org.example.xcx.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@TableName("cameras")
@Data
public class Cameras {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value = "created_at")
    private LocalDateTime createdAt;

    @TableField(value = "updated_at")
    private LocalDateTime updatedAt;

    @TableLogic
    @TableField(value = "deleted_at")
    private LocalDateTime deletedAt;

    @TableField(value = "main_id")
    private String mainId;

    @TableField(value = "camera_id")
    private String cameraId;

    @TableField(value = "name")
    private String name;

    @TableField(value = "project_id")
    private Long projectId;

    @TableField(value = "`show`")
    private Integer show; // `show` 是关键字，用反引号包裹起来

    @TableField(value = "channel_id")
    private String channelId;

    @TableField(value = "vedio_url")
    private String vedioUrl;


}