package org.example.xcx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.xcx.model.Sensors;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface SensorsMapper extends BaseMapper<Sensors> {


    int CountAll(); // 传感器总数

    List<Sensors>  CountAllInType();
}
