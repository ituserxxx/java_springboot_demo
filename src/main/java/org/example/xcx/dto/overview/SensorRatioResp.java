package org.example.xcx.dto.overview;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
@Data
public class SensorRatioResp {
    public List<Item> ratioList;


    public SensorRatioResp() {
        this.ratioList = new ArrayList<>();
    }

    public void setRatioList(Item a) {
        ratioList.add(a) ;
    }

    public static class Item {
        public String Name;
        public Double Ratio;

        public void setName(String name) {
            Name = name;
        }

        public void setRatio(Double ratio) {
            Ratio = ratio;
        }
    }
}
