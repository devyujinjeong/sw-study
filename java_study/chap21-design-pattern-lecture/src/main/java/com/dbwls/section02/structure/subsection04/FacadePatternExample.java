package com.dbwls.section02.structure.subsection04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

// 서브 시스템 1: CPU
class CPU {
    void start() {
        System.out.println("CPU가 시작됩니다...");
    }
}

// 서브 시스템 2: 메모리
class Memory {
    void load() {
        System.out.println("메모리가 로드됩니다...");
    }
}

// 서브 시스템 3: 하드 드라이브
class HardDrive {
    void read() {
        System.out.println("하드 드라이브에서 데이터를 읽습니다...");
    }
}

// 퍼사드 클래스 (복잡한 서브 시스템을 단순화)
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    // 클라이언트가 쉽게 사용할 수 있는 단순한 인터페이스 제공
    public void startComputer() {
        System.out.println("컴퓨터 부팅을 시작합니다...");
        cpu.start();
        memory.load();
        hardDrive.read();
        System.out.println("컴퓨터 부팅 완료!");
    }
}

// 클라이언트 코드
public class FacadePatternExample {
    public static void main(String[] args) throws IOException {
        // 퍼사드 객체를 사용하여 복잡한 과정 없이 컴퓨터를 쉽게 시작
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();

        /* Java API 예제
        * 내부적으로는 네트워크 요청, 스트림 관리, HTTP 요청 처리 등이 필요하지만
        * 퍼사드 역할을 하는 URL 클래스 덕분에 단순 api 호출만으로 수정할 수 있다. */
        URL url = new URL("https://naver.com");
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;

        while((line = br.readLine())!=null){
            System.out.println(line);
        }

        br.close();
    }
}
