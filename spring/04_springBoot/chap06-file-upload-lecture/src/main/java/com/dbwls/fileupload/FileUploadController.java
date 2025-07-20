package com.dbwls.fileupload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile; // 이미 다 가공되어서 전달됨

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {
    @Value("${spring.servlet.multipart.location}")
    private String filePath;

    @PostMapping("/single-file")
    public String singleFileUpload(
            @RequestParam String singleFileDescription,
            @RequestParam MultipartFile singleFile
            ){
        System.out.println("singleFileDescription : " + singleFileDescription);
        System.out.println("singleFile : " + singleFile);

        File dir = new File(filePath);
        if(!dir.exists()) dir.mkdir();

        String savedName = generateSavedFileName(singleFile);

        try {
            singleFile.transferTo(new File(filePath + "/" + savedName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "result";
    }

    @PostMapping("/multi-file")
    public String mutiFileUpload(
            @RequestParam String multiFileDescription,
            @RequestParam List<MultipartFile> multiFile,
            Model model
    ){
        // DB에 저장할 File 관련 데이터 목록
        List<FileDTO> files = new ArrayList<>();

        // 물리적으로 저장하는 부분
        try {
            for(MultipartFile multipartFile : multiFile) {
                // 디렉토리 중복 저장 되지 않도록 고유한 파일명으로 변경
                String savedName = generateSavedFileName(multipartFile);
                // 정해진 서버의 경로로 파일 저장
                multipartFile.transferTo(new File(filePath + "/" + savedName));
                String originalFilename = multipartFile.getOriginalFilename();
                // DB에서 관리할 파일 정보 추가
                files.add(new FileDTO(originalFilename, savedName, filePath, multiFileDescription));
            }
            // 파일 정보를 DB에 insert 요청하는 작업 (생략)
            model.addAttribute("message", "다중 파일 업로드 완료");
        }catch (IOException e) {
            // 파일 저장이 중간에 실패한 경우 이전에 저장 된 파일 삭제
            for(FileDTO file : files){
                new File(filePath + "/" + file.getSavedFileName()).delete();
            }
            model.addAttribute("message", "다중 파일 업로드 실패");
        }

        return "result";
    }

    private String generateSavedFileName(MultipartFile file){
        String originFileName = file.getOriginalFilename();
        // 확장자는 있어야 어떤 파일인지 구분이 가능하기 때문에 확장자는 보존한다.
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        // 랜덤한 아이디 값을 만들어 줘라!!
        return UUID.randomUUID() + ext;
    }
}

