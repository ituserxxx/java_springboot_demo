package org.example.xcx.dto.modelTmpl;

import lombok.Data;

@Data
public class ListModelRes {
    private Long id;
    private String deviceName;
    private String type;
    private String content;
    private String path;
    private String updatedTime;
}

