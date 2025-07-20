package com.dbwls.section01.singleresponsibility.resolved;

public class EmployeeRepository {
    public void save(Employee employee) {
        // 여기에서 호출해서 직원 정보를 검사하기
        validateEmployeeDate(employee);
        System.out.println(employee.getName() + "의 정보를 데이터베이스에 저장했습니다.");
    }

    /* validation 체크용 메소드는 private 으로 작성하고 굳이 외부에 노출하지 않는다. */
    private void validateEmployeeDate(Employee employee) {
        // IllegalArgumentException는 런타임 에러에 속하기 때문에, 굳이 예외 처리를 해주지 않아도 된다.
        if(employee == null)
            throw new IllegalArgumentException("직원 정보가 null일 수 없습니다.");

        // 이름이 null이거나 공백인 경우
        if(employee.getName() == null || employee.getName().trim().isEmpty())
            throw new IllegalArgumentException("직원 이름은 필수 입니다.");
    }
}