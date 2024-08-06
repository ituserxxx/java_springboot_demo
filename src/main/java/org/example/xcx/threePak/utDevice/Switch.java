package org.example.xcx.threePak.utDevice;

import org.springframework.stereotype.Component;

@Component
public class Switch extends DeviceBase {
    private String id;
    private String od;

    public Switch() {
    }

    public void setSwitchIdOd(String id, String od) {
        this.id = id;
        this.od = od;
        if (od.length() == 1) {
            this.od = String.format("DO%s", od);
        }
    }

    public int getDeviceState() {
        System.out.println("hhhhhhh-------------------" + String.format("%s/device/state?id=%s&type=%s&key=%s", this.reqUrl(), this.id, this.TypeSwitch, this.od));
        return this.getDeviceState(String.format("%s/device/state?id=%s&type=%s&key=%s", this.reqUrl(), this.id, this.TypeSwitch, this.od));
    }
}
