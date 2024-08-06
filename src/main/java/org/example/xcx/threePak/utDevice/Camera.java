package org.example.xcx.threePak.utDevice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class Camera extends DeviceBase {
    private String AccessKey = "047I4WS1-U51UBO6W-1J4BT21P-MF17IT99-92J8WIHU-944Q4KIW";
    private String Secret = "035c73f7-bb6b-4889-a715-d9eb2d1925cc";
    private String MediaServerId = "U0hIvA6l1ubtIxVr";


    @Value("${div_key.Gb28181Ws}")
    private String getGb28181Ws;

    @Value("${div_key.Gb28181Url}")
    private String getGb28181Url;


    public List<CameraT> gb28181PostRequest(String url, String body) {
        List<CameraT> respData = new ArrayList<>();
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("AccessKey", this.AccessKey);
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
            ResponseEntity<List<CameraT>> responseEntity = HttpClientSingleton.getInstance().exchange(
                    url,
                    HttpMethod.GET,
                    requestEntity,
                    new ParameterizedTypeReference<List<CameraT>>() {
                    }
            );
            respData = responseEntity.getBody();
        } catch (Exception e) {
            System.out.println("\n gb28181PostRequest err" + e.getMessage());
        }
        return respData;

    }

    public List<CameraInfo> getCameraDevices() {
        List<CameraInfo> cameraInfoList = new ArrayList<>();
        String url = this.getGb28181Url + "/SipGate/GetSipDeviceList";
        List<CameraT> data = this.gb28181PostRequest(url, null);
        for (CameraT item : data) {
            for (CameraT.SipChannel channel : item.getSipChannels()) {
                CameraInfo cameraInfo = new CameraInfo();
                cameraInfo.setId(channel.getSsrcId());
                cameraInfo.setName(channel.getSipChannelDesc().getName());
                cameraInfo.setChannelId(channel.getSipChannelDesc().getChannelID());
                int status = 0;
                if (Objects.equals(channel.getSipChannelStatus(), "ON")) {
                    status = 1;
                }
                cameraInfo.setStatus(status);
                cameraInfoList.add(cameraInfo);
            }
        }
        return cameraInfoList;
    }
}


