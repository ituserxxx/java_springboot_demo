package org.example.xcx.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@TableName("model_tmpl")
@Data
public class ModelTmpl {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String deviceName;
    private String type;
    private String path;
    private String content;
    private String modelType;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}