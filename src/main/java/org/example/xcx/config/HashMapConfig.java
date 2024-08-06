package org.example.xcx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class HashMapConfig {

    @Bean
    public Map<String, String> hashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("DDSU666", "e_meter");//DDSU666单相电表
        map.put("DTSU666", "three_meter");//DTSU666三相电表
        map.put("RY-CPM2516", "air");//空气质量变送器（六要素）
        map.put("RY-FSX", "wind");//一体风速风向传感器
        map.put("MP-508E", "soil");//土壤温湿盐传感器
        map.put("RY-YL", "rain");//型翻斗式雨量传感器
        map.put("RY-DW01/485", "w_temp");//水温温度传感器
        map.put("WCD3413", "w_quality");//水质浊度传感器
        map.put("WCD3411", "w_ph");//水质PH传感器
        map.put("WCD3412", "w_oxygen");//溶解氧传感器
        map.put("RY-CWYW/485", "w_level");//液位传感器
        map.put("WCD3416", "w_an");//氨氮传感器
        map.put("SN-3002-GZCO2WS-N01-65535-2000P", "fo_soilless");//CO2光照温湿度四合一传感器
        map.put("B-RS-L30", "light");//光照传感器
        map.put("UT-5521-LCD", "ut-5521-lcd");//5521温湿度
        map.put("HCD5016", "hcd5016_envir");//大鹏环境检测空气土壤
        return map;
    }
}