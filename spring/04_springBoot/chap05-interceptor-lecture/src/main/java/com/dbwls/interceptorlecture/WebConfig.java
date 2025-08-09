package com.dbwls.interceptorlecture;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration 
public class WebConfig implements WebMvcConfigurer {

    private final StopwatchInterceptor stopwatchInterceptor;

    // @ Autowired
    public WebConfig(StopwatchInterceptor stopwatchInterceptor){
        this.stopwatchInterceptor = stopwatchInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 어떤 요청을 가로챌 것인가?? endpoint가 stopwatch인 경로를 가로챌 것이다!
        registry.addInterceptor(stopwatchInterceptor).addPathPatterns("/stopwatch");
    }
}
