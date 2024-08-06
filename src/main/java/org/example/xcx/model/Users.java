package org.example.xcx.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@TableName("users")
@Data
public class Users {
    @TableId
    private String id;
    private String userName;
    private String phone;
    private String avatarUrl;
    private Long creatorId;
    private Long currProjectId;
    private String openid;
    private String sessionKey;
    private LocalDateTime sessionKeyTime;
    private String unionid;
    private LocalDateTime createdAt;
    private Long gender;
    private String accountOpenId;

}