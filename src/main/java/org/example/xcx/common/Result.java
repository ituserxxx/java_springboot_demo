package org.example.xcx.common;

import lombok.Data;

import java.util.HashMap;

@Data
public class Result {
    private Object data = null;
    private int code=200;
    private String msg="ok";
}
