package org.example.xcx.threePak.utDevice;


import java.util.Objects;

public class Sensor  extends DeviceBase {
    private String id;
    private String sensorType;
    private String slaveId;

    public Sensor(String id, String sensorType, String slaveId) {
        this.id = id;
        if (Objects.equals(sensorType, "air")) {
            this.sensorType =  "envir";
        }
        if (Objects.equals(sensorType,  "soil")){
            this.sensorType =  "turang";
        }
        if (Objects.equals(sensorType,  "light")){
            this.sensorType =  "light_ill";
        }

        this.slaveId = slaveId;

    }
    public int getDeviceState() {
        return this.getDeviceState( String.format("%s/device/state?id=%s&type=%s&key=%s", this.reqUrl(),this.id, this.sensorType,this.slaveId));
    }
}
