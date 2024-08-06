package org.example.xcx.controller;

import org.example.xcx.common.Result;
import org.example.xcx.dto.demo.*;
import org.example.xcx.dto.modelTmpl.AddModelReq;
import org.example.xcx.mapper.DemoMapper;
import org.example.xcx.model.Demo;
import org.example.xcx.threePak.utDevice.Camera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("api/demo/")
public class DemoController {
    @Autowired
    private DemoMapper demoMapper;
    @Autowired
    private Camera camera;
    @GetMapping("xxx")
    public Result xxx() {
        Result resp = new Result();
//        String token = (new Jwtintercetor()).CreateJWT();
        resp.setData( "999");
        return resp;
    }
    @PostMapping("testcjwt")
    public Result testJwt() {
        Result resp = new Result();
//        String token = (new Jwtintercetor()).CreateJWT();
//        resp.setData( token);
        return resp;
    }
    @PostMapping("testpjwt")
    public Result testJwt(HttpServletRequest request) {
        Result resp = new Result();
//       (new JwtInterceptor()).ValidateJWT(request.getHeader("Jwt"));

        return resp;
    }

    @PostMapping("add")
    public Result add(HttpServletRequest request, @Validated DemoAddReq req, BindingResult err) {
        Result resp = new Result();
        if (err.hasErrors()) {
            resp.setMsg(Objects.requireNonNull(err.getFieldError()).getDefaultMessage());
            return resp;
        }
        try {
            Demo record = new Demo();
            record.setId(null);
            record.setName(req.getName());
            record.setAge(req.getAge());
            demoMapper.insert(record);
            Long newId = record.getId();
            resp.setData(newId);
        } catch (Exception e) {
            resp.setMsg(e.getMessage());
        }
        return resp;
    }

    @PostMapping("update")
    public Result update(@Validated DemoUpdateReq req, BindingResult err) {
        Result resp = new Result();
        if (err.hasErrors()) {
            resp.setMsg(Objects.requireNonNull(err.getFieldError()).getDefaultMessage());
            return resp;
        }
        try {
            Demo record = new Demo();
            record.setId(req.getId());
            record.setName(req.getName());
            record.setAge(req.getAge());
            int upRes = demoMapper.updateById(record);
            if (upRes == 0) {
                throw new Exception("Update failed: no rows were updated.");
            }
            resp.setCode(301);
        } catch (Exception e) {
            resp.setMsg(e.getMessage());
        }
        return resp;
    }

    @PostMapping("del")
    public Result del(@Validated DemoDelReq req, BindingResult err) {
        Result resp = new Result();
        if (err.hasErrors()) {
            resp.setMsg(Objects.requireNonNull(err.getFieldError()).getDefaultMessage());
            return resp;
        }
        try {
            Demo record = new Demo();
            record.setId(req.getId());
            int res = demoMapper.deleteById(record);
            if (res == 0) {
                throw new Exception("del failed: no rows were del.");
            }
            resp.setCode(301);
        } catch (Exception e) {
            resp.setMsg(e.getMessage());
        }
        return resp;
    }

    @PostMapping("getOne")
    public Result getOne(@Validated DemoGetOneReq req, BindingResult err) {
        Result resp = new Result();
        if (err.hasErrors()) {
            resp.setMsg(Objects.requireNonNull(err.getFieldError()).getDefaultMessage());
            return resp;
        }
        try {

            Demo info = demoMapper.selectById(req.getId());
            if (info == null) {
                throw new Exception("selectById failed: no rows");
            }
            resp.setCode(301);
            resp.setData(info);
        } catch (Exception e) {
            resp.setMsg(e.getMessage());
        }
        return resp;
    }


    @PostMapping("getList")
    public Result getList(@Validated DemoGetListReq req, BindingResult err) {
        Result resp = new Result();
        if (err.hasErrors()) {
            resp.setMsg(Objects.requireNonNull(err.getFieldError()).getDefaultMessage());
            return resp;
        }
        try {

            List<Demo> record = demoMapper.selectPage(req.getPage(), req.getPageSize());
            if (record == null) {
                throw new Exception("selectPage failed: no rows");
            }
            resp.setCode(301);
            resp.setData(record);
        } catch (Exception e) {
            resp.setMsg(e.getMessage());
        }
        return resp;
    }

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
        result1.setCode(301);
        return result1;
    }*/
    @RequestMapping("AddProject")
    public Result AddProject(@Validated AddProjectReq addProjectReq, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.setData(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }

        AddProjectRes addProjectRes = new AddProjectRes();
        addProjectRes.setId("1233333333333333");
        result.setData(addProjectRes);
        return result;
    }


    @Value("${upload.directory}")
    private String uploadDirectory;

    @PostMapping("uploadFile")
    public Result uploadFile(@Validated AddModelReq req, BindingResult err) {
        Result resp = new Result();
        try {
            if (err.hasErrors()) {
                throw new Exception(err.getAllErrors().get(0).getDefaultMessage());
            }
            // 校验文件
            MultipartFile file = req.getFile();
            if (!file.getOriginalFilename().endsWith(".json")) {
                throw new Exception("子模板文件类型只能是json!");
            }
//             创建目录
            Path directoryPath = Paths.get(uploadDirectory);
            Files.createDirectories(directoryPath);
            // 保存文件
            String fileName = UUID.randomUUID()+"-"+file.getOriginalFilename();
            Path filePath = directoryPath.resolve(fileName);
            file.transferTo(filePath);


        } catch (Exception e) {
            resp.setCode(2100);
            resp.setData(e.getMessage());
        }
        return resp;
    }
    @GetMapping("GetCameraIsOnline")
    public Result GetCameraIsOnline() {
        Result resp = new Result();
        resp.setData(camera.getCameraDevices());
        return resp;
    }
}



