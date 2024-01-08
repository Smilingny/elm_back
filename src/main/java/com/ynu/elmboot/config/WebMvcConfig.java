package com.ynu.elmboot.config;

import com.ynu.elmboot.interceptor.JWTInterceptor;
import com.ynu.elmboot.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private RedisCache redisCache;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor(redisCache))
                .addPathPatterns("/**")
                .excludePathPatterns("/UserController/login", "/UserController/register",
                        "/CartController/listCart", "/BusinessController/listBusinessByOrderTypeId",
                        "/BusinessController/getBusinessById", "/FoodController/listFoodByBusinessId",
                        "/UserController/getUserById", "/UserController/saveUser");
    }
}
