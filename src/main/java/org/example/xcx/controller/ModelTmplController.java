


package org.example.xcx.controller;

import org.example.xcx.common.Result;
import org.example.xcx.dto.modelTmpl.*;
import org.example.xcx.mapper.ModelTmplMapper;
import org.example.xcx.model.ModelTmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/model")
public class ModelTmplController {

    private final Map<String, String> modelTypeMap;

    @Autowired
    public ModelTmplController(Map<String, String> modelTypeMap) {
        this.modelTypeMap = modelTypeMap;
    }
    @Autowired
    private ModelTmplMapper modelTmplMapper;

    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @GetMapping("list")
    public Result listModel(
            @RequestParam(value = "pageNum", defaultValue = "1") @Min(1) Integer pageNum,
             @RequestParam(value = "pageSize", defaultValue = "10") @Min(1) Integer pageSize)
    {
        Result resp = new Result();

        try {
            int offset = (pageNum - 1) * pageSize;
            List<ModelTmpl> l = modelTmplMapper.selectPage(offset, pageSize);
            List<ListModelRes> modelResList = new ArrayList<>();
            for (ModelTmpl m : l) {
                ListModelRes res = new ListModelRes();
                res.setId(m.getId());
                res.setContent(m.getContent());
                res.setDeviceName(m.getDeviceName());
                res.setType(m.getType());
                res.setPath(m.getPath());
                LocalDateTime updateTime = m.getUpdatedTime();
                String upTime = updateTime.format(outputFormatter);

                res.setUpdatedTime(upTime);
                modelResList.add(res);
            }
            // 获取总数
            int total = modelTmplMapper.countTotalModels();

            ListModel lm = new ListModel();
            lm.setList(modelResList);
            lm.setTotal(total);
            resp.setData(lm);

        } catch (Exception e) {
            resp.setCode(2103);
            resp.setMsg(e.getMessage());
        }
        return resp;
    }

    @PostMapping("add")
    public Result addDeviceModel(@Validated AddModelReq req, BindingResult err) {
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
            // 读取文件内容
            byte[] bytes = file.getBytes();
            String fileContent = new String(bytes, StandardCharsets.UTF_8);

            // 获取当前时间
            LocalDateTime now = LocalDateTime.now();

            ModelTmpl record = new ModelTmpl();
            record.setDeviceName(req.getDeviceName());
            record.setType(req.getDeviceModel());
            record.setPath(file.getOriginalFilename());

            record.setCreatedTime(now);
            record.setUpdatedTime(now);
            record.setContent(fileContent);
            record.setModelType(this.modelTypeMap.get(req.getDeviceModel()));
            modelTmplMapper.insert(record);
            Long newId = record.getId();

            AddModelRes res = new AddModelRes();
            res.setId(newId);
            resp.setData(res);
        } catch (Exception e) {
            resp.setCode(2100);
            resp.setData(e.getMessage());
        }
        return resp;
    }

    @PutMapping("update")
    public Result updateModel(@Validated UpdateModelReq req, BindingResult err) {
        Result resp = new Result();
        try {
            if (err.hasErrors()) {
                throw new Exception(err.getAllErrors().get(0).getDefaultMessage());
            }
            if (req.getId() == null || req.getId() == 0) {
                throw new Exception("id 参数必传");
            }
            // 校验文件
            MultipartFile file = req.getFile();
            if (!file.getOriginalFilename().endsWith(".json")) {
                throw new Exception("子模板文件类型只能是json!");
            }

            // 读取文件内容
            byte[] bytes = file.getBytes();
            String fileContent = new String(bytes, StandardCharsets.UTF_8);

            // 获取当前时间
            LocalDateTime now = LocalDateTime.now();

            ModelTmpl record = new ModelTmpl();
            record.setId(Long.valueOf(req.getId()));
            record.setDeviceName(req.getDeviceName());
            record.setType(req.getDeviceModel());

            record.setPath(file.getOriginalFilename());
            record.setContent(fileContent);
            record.setUpdatedTime(now);
            record.setModelType(this.modelTypeMap.get(req.getDeviceModel()));
            int rowsAffected = modelTmplMapper.updateById(record);
            if (rowsAffected == 0) {
                throw new Exception("更新失败了~");
            }
        } catch (Exception e) {
            resp.setCode(2101);
            resp.setData(e.getMessage());
        }
        return resp;
    }

    @DeleteMapping("del")

    public Result delModel(@RequestParam("id") @Min(value = 1, message = "id必须大于0") Integer id) {
        Result resp = new Result();
        try {
            if (id == null || id == 0) {
                throw new Exception("id不能为空");
            }
            // 删除数据库中的对应记录
            modelTmplMapper.deleteById(id);

        } catch (Exception e) {
            resp.setMsg(e.getMessage());
            resp.setCode(2104);
        }
        return resp;
    }
}

