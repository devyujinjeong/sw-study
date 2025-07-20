package com.dbwls.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
/* 해당 어플리케이션을 Eureka Server로 활성화 */
@EnableEurekaServer // Springframework.cloud에서 옴
public class Chap01EurekaServerLectureApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap01EurekaServerLectureApplication.class, args);
    }

}
