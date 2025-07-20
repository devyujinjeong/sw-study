package com.dbwls.section01.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
/* proxyTargetClass = true : Proxy 객체 생성의 방식으로 CGLib 방식을 사용
* target object가 class인 경우에도 proxy 객체 생성 가능
*  */

// 이것까지 설정해야 기능을 사용하는 준비가 끝났다고 할 수 있음
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ContextConfiguration {
}
