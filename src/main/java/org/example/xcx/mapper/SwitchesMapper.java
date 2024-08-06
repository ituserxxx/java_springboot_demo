package org.example.xcx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.xcx.model.Switches;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface SwitchesMapper extends BaseMapper<Switches> {
    int CountAll(); // 开关总数

    List<Switches> FindAllSwitches(); // 查询所有开关
}
