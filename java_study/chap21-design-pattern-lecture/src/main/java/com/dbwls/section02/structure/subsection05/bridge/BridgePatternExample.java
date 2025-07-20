package com.dbwls.section02.structure.subsection05.bridge;

// 장치(Device) 인터페이스 (구현 부분)
interface Device {
    void turnOn();
    void turnOff();
}

// TV 클래스 (Device 인터페이스 구현)
class TV implements Device {
    public void turnOn() {
        System.out.println("TV 전원이 켜졌습니다.");
    }

    public void turnOff() {
        System.out.println("TV 전원이 꺼졌습니다.");
    }
}

// 라디오 클래스 (Device 인터페이스 구현, 추가 가능)
class Radio implements Device {
    public void turnOn() {
        System.out.println("라디오 전원이 켜졌습니다.");
    }

    public void turnOff() {
        System.out.println("라디오 전원이 꺼졌습니다.");
    }
}

// 리모컨 추상 클래스 (추상화 부분)
abstract class RemoteControl {
    protected Device device; // 구현체와 연결

    public RemoteControl(Device device) {
        this.device = device;
    }

    abstract void togglePower();
}

// 기본 리모컨 (추상화 확장)
class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }

    public void togglePower() {
        System.out.println("전원 버튼을 누릅니다.");
        device.turnOn();
    }
}

// 고급 리모컨 (추상화 확장, 추가 가능)
class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void togglePower() {
        System.out.println("전원 버튼을 누릅니다.");
        device.turnOn();
        System.out.println("밝기 조정을 시작합니다.");
        System.out.println("밝기 조정을 시작합니다.");
    }
}

// 클라이언트 코드
public class BridgePatternExample {
    public static void main(String[] args) {
        // TV와 기본 리모컨 연결
        Device tv = new TV();
        RemoteControl basicRemote = new BasicRemote(tv);
        basicRemote.togglePower();

        System.out.println("----------------");

        // 라디오와 고급 리모컨 연결
        Device radio = new Radio();
        RemoteControl advancedRemote = new AdvancedRemote(radio);
        advancedRemote.togglePower();
    }
}