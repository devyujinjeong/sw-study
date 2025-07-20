package com.dbwls.section01.statement;

import java.sql.*;
import java.util.Scanner;

import static com.dbwls.common.JDBCTemplate.close;
import static com.dbwls.common.JDBCTemplate.getConnection;

/* 사번을 Scanner로 입력 받아서 사원의 정보를 출력하는 프로그램
* 사원의 정보 : emp_id, emp_name, salary
* 없는 사번이면 "해당 사원의 조회 결과가 없습니다. " 출력*/
public class Application02 {
    public static void main(String[] args) {
        Connection con = getConnection(); // 실제 db와 연결되어 있는 객체
        Statement stmt = null; // connection을 통해서 생성
        ResultSet rset = null; // 조회를 하면 이러한 set을 반환

        Scanner sc = new Scanner(System.in);
        System.out.print("조회하고 싶은 사번 : ");
        int id = sc.nextInt();

        try {
            /* Statement: 쿼리를 운반하고 그 결과를 반환하는 객체*/
            stmt = con.createStatement();
            /* ResultSet : Statement 객체를 통해 조회 처리된 결과를 다루는 객체 */
            rset = stmt.executeQuery("SELECT emp_id, emp_name, salary FROM employee where emp_id = " + id);

            if(!rset.next()){
                System.out.println("해당 사원의 조회 결과가 없습니다.");
            }else { // 결과 행의 존재 여부를 확인
                // 타입을 맞춰서 꺼내주기
                System.out.print(id + " ");
                System.out.print(rset.getString("emp_name") + " ");
                System.out.println(rset.getInt("salary"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 자원은 항상 반납해야 한다!
            close(rset);
            close(stmt);
            close(con);
        }
    }

}
