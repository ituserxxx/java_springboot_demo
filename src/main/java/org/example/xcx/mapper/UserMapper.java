package org.example.xcx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.xcx.model.Users;
import org.springframework.stereotype.Service;


@Service
public interface UserMapper extends BaseMapper<Users> {


    int CountAll();    // 用户总数

    int CountAllHasProject();   // 加入项目的用户数

    int CountAllActive30(); // 30天活跃用户数

    int CountAllNewly30();   // 30天新增用户

    int CountLeave90(); // 90天流失用户

}
