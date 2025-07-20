package com.dblws.section02.uses.subsection03.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application3 {
    public static void main(String[] args) {
        List<Member> memberList = Arrays.asList(
                new Member("test01", "홍길동"),
                new Member("test02", "유관순"),
                new Member("test03", "신사임당"),
                new Member("test04", "신사")
        );

        /* 스트림의 최종 연산 중 하나인 collect에 대해 이해하고 사용할 수 있다. */

        /* 1. List<String> 타입의 멤버의 이름을 관리하는 데이터 */
        List<String> memberNames = memberList.stream()
//                .map(member -> member.getMemberName())    메소드 참조로 변경
                .map(Member::getMemberName)
//                .collect(Collectors.toList());   불변 List로 변경
                .toList();

        System.out.println("memberNames : " + memberNames);

        /* 2. `,`를 넣어서 데이터 반환하기 */
        String str = memberList.stream()
                .map(Member::getMemberId)
                .collect(Collectors.joining(","));
        System.out.println("str : " + str);

        /* 시작과 끝에 넣을 문자를 선택할 수 있음*/
        // List를 스트림화하고,
        String str2 = memberList.stream()
                .map(Member::getMemberId)
                .collect(Collectors.joining(" || ", "**", "**"));
        System.out.println("str2 : " + str2);

        // 멤버들의 이름의 길이별로 그룹화 하기
        Map<Integer, Long> countByNameLength =
                memberList.stream()
                        .collect(
                                Collectors.groupingBy(
                                        m -> m.getMemberName().length(),
                                        Collectors.counting()
                                )
                        );
        System.out.println("countByNameLength" + countByNameLength);


    }
}

