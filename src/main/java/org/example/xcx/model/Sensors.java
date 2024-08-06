package org.example.xcx.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("sensors")
public class Sensors {

    @TableId(type = IdType.AUTO)
    private Long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private String name;

    private String gatewayId;

    private Long projectId;

    private String type;

    private String protocol;

    private String startBits;

    private String stopBits;

    private String baudRate;

    private String slaveStation;

    private String p485;

    private Integer show;

    private String flowsId;
    private Long AsFieldCountNumber;
    private String AsFieldKey;
}