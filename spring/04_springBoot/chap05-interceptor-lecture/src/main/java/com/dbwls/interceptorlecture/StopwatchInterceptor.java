package com.dbwls.interceptorlecture;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *  interceptor 구현하기
 *  (1) Controller에 가기 전에 메소드를 호출
 *  (2) 이후 Controller에 있는 메소드를 호출
 *  (3) 후처리 메소드인 `postHandler`메소드를 호출
 *  (4) 뷰가 렌더링 된 이후 최종적으로 `afterCompletion` 메소드를 호출
 *  (5) 마지막에는 menuService에 있는 메소드까지 호출해 마무리 한다.
**/
@Component
public class StopwatchInterceptor implements HandlerInterceptor {

    private final MenuService menuService;

    /* Interceptor는 스프링 컨테이너에 존재하는 빈을 의존성 주입 받을 수 있다.
       (기본 생성자가 이것만 있으므로 @Autowired 사용할 필요 없음) */
    public StopwatchInterceptor(MenuService menuService){
        this.menuService = menuService;
    }

    /* 전처리 메소드 */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandler 메소드 동작");
        long startTime = System.currentTimeMillis();
        // 실행 시작 시간을 request에 attribute로 저장 (여러 메소드에서 같은 데이터를 공유하기 위함)
        // attribute는 개발자가 직접 임의로 데이터를 붙일 수 있는 '저장 공간' 이다.
        request.setAttribute("startTime", startTime);
        return true; // 컨트롤러 핸들러 메소드 호출로 이어짐, false이면 호출하지 않는다.
    }

    /* 후처리 메소드 : 걸린 시간을 구하는 메소드 */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /* ModelAndView 객체를 후처리시 가공할 수도 있다. */
        System.out.println("postHandler 메소드 호출");
        long endTime = System.currentTimeMillis();
        // 위에서 저장한 시작시간을 빼오기
        long startTime = (long)request.getAttribute("startTime");
        // 걸린 시간을 구한다.
        modelAndView.addObject("interval",endTime-startTime);
    }

    /* 뷰가 렌더링 된 이후 동작하는 메소드, Exception 사용 가능 */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion 메소드 호출");
        menuService.method();
    }
}
