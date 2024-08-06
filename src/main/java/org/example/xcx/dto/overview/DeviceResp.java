package org.example.xcx.dto.overview;

import lombok.Data;

@Data
public class DeviceResp {
    public Item dcc;
    public Item switchDevice;
    public Item sensor;
    public Item camera;

    // Constructors
    public DeviceResp() {
        this.dcc = new Item();
        this.switchDevice = new Item();
        this.sensor = new Item();
        this.camera = new Item();
    }

    public void setDcc(Item dcc) {
        this.dcc = dcc;
    }

    public void setSwitchDevice(Item switchDevice) {
        this.switchDevice = switchDevice;
    }

    public void setSensor(Item sensor) {
        this.sensor = sensor;
    }

    public void setCamera(Item camera) {
        this.camera = camera;
    }

    // Inner classes
    public static class Item {
        public int total;
        public int online;
        public int offline;

        // Getters and setters

        public void setTotal(int total) {
            this.total = total;
        }

        public void setOnline(int online) {
            this.online = online;
        }


        public void setOffline(int offline) {
            this.offline = offline;
        }
    }

}
