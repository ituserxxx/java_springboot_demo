package org.example.xcx.threePak.utDevice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public abstract class DeviceBase {


    public String TypeGateway = "gateway";
    public String TypeSwitch = "switch";
    public String TypeSensor = "sensor";

    @Value("${div_key.CLOUD_BACKEND}")
    private String IpUrl;




    public String reqUrl() {
        return String.format("http://%s/api/wx", this.IpUrl);
    }

    public int getDeviceState(String url) {
        try {
            DeviceHttpResp data = HttpClientSingleton.getInstance().getForObject(url, DeviceHttpResp.class);
            assert data != null;
            Object respData = data.getData();
            if (respData instanceof Integer) {
                int numericData = (Integer) respData;

                // 现在numericData是一个整数，可以对其进行操作或者打印
                System.out.println("Numeric data: " + numericData);
                return numericData;
            } else {
                System.out.println("Data is not of type Integer");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" getDeviceState err: " + e.getMessage());
        }
        return 2;
    }


}
