package org.example.xcx.controller;

import org.example.xcx.common.Result;
import org.example.xcx.dto.overview.*;
import org.example.xcx.mapper.*;
import org.example.xcx.model.Gateways;
import org.example.xcx.model.Sensors;
import org.example.xcx.model.Switches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.text.DecimalFormat;
import java.util.List;

@RestController
@RequestMapping("api/overview/")
public class OverviewController {
    @Autowired
    private GatewaysMapper gatewaysMapper;
    @Autowired
    private SensorsMapper sensorsMapper;
    @Autowired
    private SwitchesMapper switchesMapper;

    @Autowired
    private org.example.xcx.threePak.utDevice.Gateways utDeviceGateways;
    @Autowired
    private org.example.xcx.threePak.utDevice.Switch utDeviceSwitch;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProjectMapper projectMapper;

    @GetMapping("device")
    public Result device() {
        Result resp = new Result();
        DeviceResp data = new DeviceResp();
        DeviceResp.Item dcc = new DeviceResp.Item();
        DeviceResp.Item switchDevice = new DeviceResp.Item();
        DeviceResp.Item sensor = new DeviceResp.Item();
        DeviceResp.Item camera = new DeviceResp.Item();

        // dcc 数据
        dcc.online = 0;
        List<Gateways> gatewaysIds = gatewaysMapper.FindAllGatewaysId();
        for (Gateways ga : gatewaysIds) {
            utDeviceGateways.setId(ga.getId());
            int sta = utDeviceGateways.getDeviceState();
            if (sta == 1) {
                dcc.online++;
            }
        }

        dcc.setTotal(gatewaysMapper.CountAll());
        dcc.setOnline(dcc.online);
        dcc.setOffline(dcc.total - dcc.online);

        // 开关 数据
        switchDevice.online = 0;
        List<Switches> switchesList = switchesMapper.FindAllSwitches();
        for (Switches sw : switchesList) {
            utDeviceSwitch.setSwitchIdOd(sw.getGatewayId(), sw.getDoAction());
            int sta = utDeviceSwitch.getDeviceState();
            if (sta == 1) {
                switchDevice.online++;
            }
        }
        switchDevice.setTotal(switchesMapper.CountAll());
        switchDevice.setOnline(switchDevice.online);
        switchDevice.setOffline(switchDevice.total - switchDevice.online);

        // 传感器 数据


        data.setDcc(dcc);
        data.setSwitchDevice(switchDevice);
        data.setSensor(sensor);
        data.setCamera(camera);

        resp.setData(data);

        return resp;
    }

    @GetMapping("user")
    public Result user() {
        Result resp = new Result();
        UserResp data = new UserResp();
        // 创建 DecimalFormat 对象，指定保留两位小数的格式
        DecimalFormat df = new DecimalFormat("#.##");

        data.setUsersTotal(userMapper.CountAll());
        data.setProjectUsersNum(userMapper.CountAllHasProject());
        data.setProjectNum(projectMapper.CountAll());
        data.setDeviceNum(gatewaysMapper.CountAll());
        data.setActiveUsers(userMapper.CountAllActive30());
        data.setActivityRate(Double.parseDouble(df.format((data.getActiveUsers() / (double) data.getUsersTotal()))));
        data.setNewUsers(userMapper.CountAllNewly30());
        data.setNewUsersRate((Double.parseDouble(df.format(((double) userMapper.CountAllNewly30() / (double) data.getUsersTotal())))));
        data.setLostUsers(userMapper.CountLeave90());
        data.setLostUsersRate((Double.parseDouble(df.format(((double) data.getLostUsers() / (double) data.getUsersTotal())))));
        resp.setData(data);
        return resp;
    }

    @GetMapping("rank")
    public Result rank(@RequestParam(value = "key", defaultValue = "city") @Min(1) String key) {
        Result resp = new Result();
        RankResp data = new RankResp();
        List<Gateways> dbList = gatewaysMapper.FindAllOrderByCountDcc(key);
        for (Gateways item : dbList) {
            data.setName(item.getAsName());
            data.setNum(Math.toIntExact(item.getAsFieldCountNumber()));
        }
        resp.setData(data);
        return resp;
    }

    @GetMapping("dccMonthStat")
    public Result dccStat() {
        Result resp = new Result();
        DccMonthStatResp data = new DccMonthStatResp();
        List<Gateways> dbList = gatewaysMapper.Last6MonthsDccStat();
        for (Gateways item : dbList) {
            data.setMonths(item.getAsKey());
            data.setDcc_num(Math.toIntExact(item.getAsFieldCountNumber()));
        }
        resp.setData(data);
        return resp;
    }

    @GetMapping("sensorRatio")
    public Result sensorRatio() {
        Result resp = new Result();
        SensorRatioResp data = new SensorRatioResp();

        SensorRatioResp.Item air = new SensorRatioResp.Item();
        air.setName("空气传感器");
        air.setRatio((double) 0);
        SensorRatioResp.Item w_level = new SensorRatioResp.Item();
        w_level.setName("液位传感器");
        w_level.setRatio((double) 0);
        SensorRatioResp.Item w_quality = new SensorRatioResp.Item();
        w_quality.setName("水质浊度传感器");
        w_quality.setRatio((double) 0);
        SensorRatioResp.Item w_ph = new SensorRatioResp.Item();
        w_ph.setName("水质PH传感器");
        w_ph.setRatio((double) 0);
        SensorRatioResp.Item w_oxygen = new SensorRatioResp.Item();
        w_oxygen.setName("溶解氧传感器");
        w_oxygen.setRatio((double) 0);
        SensorRatioResp.Item other = new SensorRatioResp.Item();
        other.setName("其他");
        other.setRatio((double) 0);

        // 创建 DecimalFormat 对象，指定保留两位小数的格式
        DecimalFormat df = new DecimalFormat("#.##");
        int total = sensorsMapper.CountAll();
        List<Sensors> SensorsList = sensorsMapper.CountAllInType();

        for (Sensors item : SensorsList) {
            SensorRatioResp.Item sondata = new SensorRatioResp.Item();
            double ratio = (Double.parseDouble(df.format(((item.getAsFieldCountNumber() / (double) total)))));
            switch (item.getAsFieldKey()) {
                case "air" -> {
                    air.setRatio(ratio);
                }
                case "w_level" -> {
                    w_level.setRatio(ratio);
                }
                case "w_quality" -> {
                    w_quality.setRatio(ratio);

                }
                case "w_ph" -> {
                    w_ph.setRatio(ratio);

                }
                case "w_oxygen" -> {
                    w_oxygen.setRatio(ratio);

                }
            }
        }

        data.setRatioList(air);
        data.setRatioList(w_level);
        data.setRatioList(w_quality);
        data.setRatioList(w_ph);
        data.setRatioList(w_oxygen);
        other.setRatio(Double.parseDouble(df.format(((total-SensorsList.size()/ (double) total)))));
        data.setRatioList(other);

        resp.setData(data);
        return resp;
    }

    @GetMapping("sensor")
    public Result sensor() {
        Result resp = new Result();
        // todo
        return resp;
    }
}
