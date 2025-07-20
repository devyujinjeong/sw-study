package com.ohgiraffers.realtime.section03.sse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class SseEmitterStorageConfig {
    @Bean
    public Map<String, SseEmitter> sseEmitters() {
        return new ConcurrentHashMap<>();
    }
}
