package org.example.xcx.controller;

import org.example.xcx.common.JwtUtil;
import org.example.xcx.common.Result;
import org.example.xcx.dto.AdminUser.LoginReq;
import org.example.xcx.dto.AdminUser.LoginRes;
import org.example.xcx.mapper.AdminUserMapper;
import org.example.xcx.model.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/")
public class AdminUserController {
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private AdminUserMapper userMapper;

    @Autowired
    private JwtUtil jwt;

    @PostMapping("login")
    public Result Login(@Validated @RequestBody LoginReq req, BindingResult err) {
        Result resp = new Result();
        try {

            if (err.hasErrors()) {
                throw new Exception(err.getAllErrors().get(0).getDefaultMessage());
            }
            // 查找用户
            AdminUser u = userMapper.selectByPhone(req.getPhone());
            if (u == null) {
                throw new Exception("用户名不存在");
            }

            // 校验密码
            boolean isPasswordMatch = passwordEncoder.matches(req.getPassword(), u.getPassword());
            if (!isPasswordMatch) {
                throw new Exception("密码/用户名错误");
            }
            resp.setMsg("登录成功");
            // 生成token
            String token = jwt.createToken(u.getId(), u.getPhone());
            // 把token赋值到LoginRes
            LoginRes res = new LoginRes();
            res.setToken(token);

            resp.setData(res);

        } catch (Exception e) {
            resp.setCode(2300);
            resp.setMsg(e.getMessage());
        }
        return resp;
    }
    @PostMapping("add")
    public Result add(@Validated @RequestBody LoginReq req, BindingResult err) {
        Result resp = new Result();
        try {
            if (err.hasErrors()) {
                throw new Exception(err.getAllErrors().get(0).getDefaultMessage());
            }
            // 查找用户
            AdminUser u = userMapper.selectByPhone(req.getPhone());
            if (u !=null) {
                throw new Exception("Phone已经存在");
            }
            AdminUser nu = new AdminUser();
            nu.setPhone(req.getPhone());
            nu.setPassword(passwordEncoder.encode(req.getPassword()));
            userMapper.insert(nu);
            Integer newId = nu.getId();
            LoginRes res = new LoginRes();
            res.setToken(newId.toString());
        } catch (Exception e) {
            resp.setCode(2301);
            resp.setMsg(e.getMessage());
        }
        return resp;
    }
}
