package org.example.xcx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.xcx.model.Gateways;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GatewaysMapper extends BaseMapper<Gateways> {
    List<Gateways> FindAllOrderByCountDcc(@Param("orderByField") String field); // 省、市 dcc 数量排名

    List<Gateways> Last6MonthsDccStat(); // 最近6个月Dcc新增数量统计

    List<Gateways> FindAllGatewaysId(); // 查询所有网关的id

    int CountAll();    // Dcc总数


}
