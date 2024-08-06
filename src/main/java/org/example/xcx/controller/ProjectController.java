package org.example.xcx.controller;

import org.example.xcx.common.JwtUtil;
import org.example.xcx.common.Result;
import org.example.xcx.dto.demo.AddProjectReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @Autowired
    private JwtUtil jwtUtil;

    /*@Autowired
    private UserMapper userMapper;

    @RequestMapping("getAllUser")
    @Transactional
    public Result getAllUser(ServletRequest servletRequest, @Validated User user,BindingResult result){
        Result result1=new Result();
        if(result.hasErrors()){
            result1.setData(result.getFieldError().getDefaultMessage());
            result1.setOk(false);
            return result1;
        }
        userMapper.insert(user);

        *//*QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("age",user.getAge());
        List<User> userList=userMapper.selectList(queryWrapper);*//*

        result1.setData("插入成功");
        result1.setOk(true);
        return result1;
    }*/
    @PostMapping("AddProject")
    public Result AddProject(@Validated AddProjectReq addProjectReq, BindingResult bindingResult) {


        System.out.println("请求来到这里");
        System.out.println("AddProjectReq：" + addProjectReq);
        Result result = new Result();
//        if(bindingResult.hasErrors()){
//            result.setData(bindingResult.getFieldError().getDefaultMessage());
//            result.setOk(false);
//            return result;
//        }
//
//        AddProjectRes addProjectRes = new AddProjectRes();
//        addProjectRes.setId("1233333333333333");
//        result.setData(addProjectRes);
        return result;

        //        Result result=new Result();
//        if(bindingResult.hasErrors()){
//            result.setData(bindingResult.getFieldError().getDefaultMessage());
//            result.setOk(false);
//            return result;
//        }
//
//        AddProjectRes addProjectRes=new AddProjectRes();
//        addProjectRes.setId("1233333333333333");
//        result.setData(addProjectRes);
//        return result;
    }
}
