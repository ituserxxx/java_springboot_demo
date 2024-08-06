package org.example.xcx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.xcx.model.Demo;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public interface DemoMapper extends BaseMapper<Demo> {
    List<Demo> selectPage(@Param("pageNum") int page, @Param("pageSize") int pageSize);
}
