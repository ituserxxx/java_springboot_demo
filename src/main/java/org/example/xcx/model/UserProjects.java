package org.example.xcx.model;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
@TableName("user_projects")
@Data
public class UserProjects {

    @TableId(type = IdType.AUTO)
    private Long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private String userId;

    private Long roleId;

    private Long projectId;

    private String inviter;

    private Long warn;

    private Long task;

    private Long device;

    private Long msgCount;
}
