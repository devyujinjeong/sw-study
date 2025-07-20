package com.dbwls.section03.uses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        /* 예외 처리를 많이 사용한 io 패키지에서 예외 처리를 사용하는 구문을 이해할 수 있다.
        * 아직 IO는 학습하지 않았으므로 IO 문법보다는 try-catch 블럭의 실제 사용과 흐름에 집중한다.*/
        BufferedReader br = null;

        try {
            /* FileReader 생성자에 throws FileNotFoundException이 있으므로
            * 호출부에서는 예외처리가 강제화 된다. -> try catch 블럭 사용 */
            br = new BufferedReader(new FileReader("test.txt"));

            /* readLine() 메소드에 throws IOException이 있으므로 예외 처리 강제화 */
            String s;
            while((s=br.readLine())!=null){
                System.out.println(s);
            }
            /* IOException은 입출력과 관련해 추상화 된 클래스로
            * FileNotFoundException도 IOException의 후손이다. */
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
            /* 오류가 발생하거나 발생하지 않거나 무조건 동작해야 하는 구문
            * 일반적으로 IO에서는 사용한 자원을 반납하는 용도로 사용한다. */

            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }


    }
}
