package com.dbwls.section03.filterstream;

import java.io.*;

public class Application3 {
    public static void main(String[] args) {
        /* DataInputStream/DataOuputStream */
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("score.txt"))){
            // 텍스트만 유의미하게 보여진다.
            dos.writeUTF("정유진");
            dos.writeInt(95);
            dos.writeChar('A');

            dos.writeUTF("홍길동");
            dos.writeInt(85);
            dos.writeChar('B');

            dos.writeUTF("이순신");
            dos.writeInt(75);
            dos.writeChar('C');

        }catch (IOException e){
            e.printStackTrace();
        }

        try(DataInputStream dis = new DataInputStream(new FileInputStream("score.txt"))){
            while(true){
                /* 반드시 순서대로 읽어와야 한다. 그러지 않으면 유의미하지 않은 데이터를 읽어온다. */
                System.out.println(dis.readUTF());
                System.out.println(dis.readInt());
                System.out.println(dis.readChar());
            }
        }catch(EOFException e){ // IOException을 상속 받고 있지만 좀 더 세부적으로 보기 위해서 분리함
            /* read자료형() 메소드는 파일에서 더 이상 읽어올 값이 없는 경우
            EOFException (End Of File) 을 발생시킨다.
             */
            System.out.println("파일 읽기가 완료 됐습니다");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
