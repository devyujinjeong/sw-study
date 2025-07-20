package com.dbwls.section03.componentscan.subsection01.java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/* @Configuration
: @Component의 구체화 어노테이션으로 설정 정보를 담는 클래스로
여기에 정의된 내용을 기반으로 Bean을 등록 */
@Configuration("configurationContextJava")
/* @ComponentScan : Componenet Scan과 관련된 설정을 기입하며, basePackages를 기입하지 않으면
* default는 현재 패키지 기준으로 Scan이 수행 된다. */
@ComponentScan(basePackages = "com.dbwls")
public class ConfigurationContext {

}
