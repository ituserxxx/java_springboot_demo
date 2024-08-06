package org.example.xcx.dto.overview;

import java.util.List;
import lombok.Data;
@Data
public class SensorResp {
    public static class Sensor {
        private String id;
        private String type;
        private String name;
        private String value;
        private int state;

        // Constructors
        public Sensor() {
        }

        // Getters and Setters

        public void setId(String id) {
            this.id = id;
        }


        public void setType(String type) {
            this.type = type;
        }


        public void setName(String name) {
            this.name = name;
        }


        public void setValue(String value) {
            this.value = value;
        }


        public void setState(int state) {
            this.state = state;
        }


    }

    private List<Sensor> sensor;

    // Constructors
    public SensorResp() {
    }

    public void setSensor(List<Sensor> sensor) {
        this.sensor = sensor;
    }


}
