package org.example.xcx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import org.example.xcx.model.AdminUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminUserMapper extends BaseMapper<AdminUser> {
    List<AdminUser> selectPage(@Param("pageNum") int page, @Param("pageSize") int pageSize);


    AdminUser selectByPhone(String phone);


}
