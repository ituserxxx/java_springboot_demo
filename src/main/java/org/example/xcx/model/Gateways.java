package org.example.xcx.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@TableName("gateways")
@Data
public class Gateways {
    @TableId
    private String id;
    private String name;
    private String mac;
    private String model;
    private String version;
    private Long runTime;
    private String deviceTime;
    private String doOccupancy;
    private String p485Occupancy;
    private Long projectId;
    private String creatorId;
    private LocalDateTime createdAt;
    private String Province;
    private String City;
    private String Region;

    private Long AsFieldCountNumber;
    private String AsKey;
    private String AsName;
}
