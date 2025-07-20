package com.dbwls.section02.structure.subsection01.adapter;

import java.io.*;

// 클라이언트가 사용하는 공통 인터페이스
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// 기존 MP3 플레이어 클래스
class MP3Player implements MediaPlayer {
    public void play(String audioType, String fileName) {
        System.out.println("MP3 파일 재생 중: " + fileName);
    }
}

// 기존 MP4 플레이어 (MediaPlayer 인터페이스와 호환되지 않음)
class MP4Player {
    public void playMP4(String fileName) {
        System.out.println("MP4 파일 재생 중: " + fileName);
    }
}

// 어댑터 클래스 (MediaPlayer 인터페이스를 구현하여 MP4Player와 연결)
class MediaAdapter implements MediaPlayer {
    private MP4Player mp4Player = new MP4Player();

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp4")) {
            mp4Player.playMP4(fileName); // MP4 플레이어의 메서드를 호출하여 변환
        } else {
            System.out.println("지원되지 않는 형식: " + audioType);
        }
    }
}

// 클라이언트 코드 (어댑터 패턴을 활용하여 MP4 파일도 재생 가능)
public class AdapterPatternExample {
    public static void main(String[] args) throws FileNotFoundException {
        MediaPlayer mp3Player = new MP3Player();
        mp3Player.play("mp3", "music.mp3");

        MediaPlayer adapter = new MediaAdapter();
        adapter.play("mp4", "video.mp4");

        /* Java API 예시 */
        InputStream inputStream = new FileInputStream("example.txt");
        /* InputStreamReader 라는 일종의 어댑터를 끼워서 사용 */
        Reader reader = new InputStreamReader(inputStream);
    }

}
