package com.dbwls.requestmapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 이 위치가 componentScan이 일어나는 파일!
// 자동 설정이 활성화 : 자동 설정되어야 하는 bean이 등록
// 여기 있는 main 메소드가 실행됨으로써 이 프로젝트가 실행된다.
public class Chap01RequestMappingLectureApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap01RequestMappingLectureApplication.class, args);
    }

}
