package org.example.xcx.threePak.utDevice;

import org.springframework.stereotype.Component;

@Component
public class Gateways extends DeviceBase {
    private String id;

    public Gateways() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDeviceState() {
        return super.getDeviceState(String.format("%s/device/state?id=%s&type=%s&key=%s", this.reqUrl(), this.id, this.TypeGateway, ""));
    }
}
