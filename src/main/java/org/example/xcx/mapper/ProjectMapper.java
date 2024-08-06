package org.example.xcx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.xcx.model.Projects;
import org.springframework.stereotype.Service;


@Service
public interface ProjectMapper extends BaseMapper<Projects> {


    int CountAll(); // 项目总数

}
