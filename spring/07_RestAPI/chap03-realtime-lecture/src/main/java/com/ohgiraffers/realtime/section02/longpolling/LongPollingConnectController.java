package com.ohgiraffers.realtime.section02.longpolling;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;

@RestController
@RequestMapping("/long-polling")
@RequiredArgsConstructor
public class LongPollingConnectController {

    private final Map<String, DeferredResult<String>> deferredResults;

    @GetMapping("/connect/{userId}")
    public DeferredResult<String> connect(@PathVariable String userId) {
        DeferredResult<String> result = new DeferredResult<>(10000L); // 10초 제한
        deferredResults.put(userId, result);

        // 유저에 대한 지연 응답을 제거
        result.onCompletion(() -> deferredResults.remove(userId));
        result.onTimeout(() -> {
            // timeout 됐다는 것을 알려줌
            result.setResult("알림 없음 (타임아웃)");
            deferredResults.remove(userId);
        });

        return result;
    }
}