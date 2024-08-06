package org.example.xcx.threePak.utDevice;

public class DeviceHttpResp {
    private int code;
    private String msg;
    private Object data; // 可以使用任意的数据类型，这里使用Object代表任意类型

    // 构造方法
    public DeviceHttpResp() {
    }

    // Getter和Setter方法
    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
