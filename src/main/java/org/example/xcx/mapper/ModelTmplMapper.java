package org.example.xcx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.xcx.model.ModelTmpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ModelTmplMapper extends BaseMapper<ModelTmpl> {
    List<ModelTmpl> selectPage(@Param("offset") Integer page, @Param("pageSize") Integer pageSize);
    int countTotalModels();

    // 查询所有的模型文件
    List<ModelTmpl> selectAll();
}