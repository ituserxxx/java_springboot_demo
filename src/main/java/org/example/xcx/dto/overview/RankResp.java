package org.example.xcx.dto.overview;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
@Data
public class RankResp {
    public List<String> name;
    public List<Integer> num;

    public RankResp() {
        this.name = new ArrayList<>();
        this.num = new ArrayList<>();
    }

    public void setName(String name) {
        this.name.add(name);
    }

    public void setNum(Integer num) {
        this.num.add(num);
    }
}
