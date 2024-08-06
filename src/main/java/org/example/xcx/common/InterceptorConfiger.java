package org.example.xcx.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiger implements WebMvcConfigurer {



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

//        registry.addResourceHandler("/uploads/**") // 设置访问路径前缀
//                // 相对于程序运行目录
//                .addResourceLocations("file:" + System.getProperty("user.dir") + "/resources/static/uploads/"); // 设置文件存储的目录
//
//
//        registry.addResourceHandler("/**") // 设置访问路径前缀
//                // 相对于程序运行目录
//                .addResourceLocations("file:" +System.getProperty("user.dir") + "/resources/dist/"); // 设置文件存储的目录
    }

    /*
在SpringBoot中，默认情况下，共有5个地方可以放静态资源，分别是：
classpath:/META-INF/resources/
classpath:/resources/
classpath:/static/
classpath:/public/
*/
    @Bean
    public Jwtintercetor getJwtintercetor() {
        return new Jwtintercetor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.
                addInterceptor(getJwtintercetor()).
                addPathPatterns("/api/**").// 这里配置拦截的路径
                excludePathPatterns("/api/demo/**"). // 排demo请求;
                excludePathPatterns("/aaaa/**"). // 排除aaaa请求;
                excludePathPatterns("/uploads/**"). // 排除uploads请求;
                excludePathPatterns("/api/user/login").// 排除登录请求;
                excludePathPatterns("/api/user/add");// 排除登录请求;
    }


}
