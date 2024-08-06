package org.example.xcx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.xcx.model.Cameras;
import org.springframework.stereotype.Service;


@Service
public interface CamerasMapper extends BaseMapper<Cameras> {


    int CountAll(); // 摄像头总数


}
