package org.example.xcx.threePak.utDevice;

import org.springframework.web.client.RestTemplate;


public class HttpClientSingleton {

    private static class RestTemplateHolder {
        private static final RestTemplate INSTANCE = new RestTemplate();
    }
    public static RestTemplate getInstance() {
        return RestTemplateHolder.INSTANCE;
    }
}
