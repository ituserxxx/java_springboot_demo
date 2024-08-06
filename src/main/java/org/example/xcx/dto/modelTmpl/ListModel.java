package org.example.xcx.dto.modelTmpl;

import lombok.Data;

import java.util.List;

@Data
public class ListModel {
    private List<ListModelRes> list;
    private Integer total;
}
