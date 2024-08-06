package org.example.xcx.dto.overview;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
@Data
public class DccMonthStatResp {
    public List<String> months;
    public List<Integer> dcc_num;

    public void setMonths(String months) {
        this.months.add(months);
    }

    public void setDcc_num(Integer dcc_num) {
        this.dcc_num.add(dcc_num);
    }

    public DccMonthStatResp() {
        this.months =  new ArrayList<>();
        this.dcc_num = new ArrayList<>();
    }


}
