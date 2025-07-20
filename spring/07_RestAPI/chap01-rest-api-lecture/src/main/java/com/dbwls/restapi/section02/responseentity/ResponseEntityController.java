package com.dbwls.restapi.section02.responseentity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entity")
public class ResponseEntityController {

    private List<UserDTO> users;

    public ResponseEntityController() {
        users = new ArrayList<>();

        users.add(
                new UserDTO(1, "user01", "pass01", "홍길동")
        );
        users.add(
                new UserDTO(2, "user02", "pass02", "유관순")
        );
        users.add(
                new UserDTO(3, "user03", "pass03", "이순신")
        );
    }

    /* 1. GetMapping - Read*/
    @GetMapping("/users")
    public ResponseEntity<ResponseMessage> findAllUsers(){
        /* 응답 헤더 설정 : JSON 응답이 default이기는 하나 변경이 필요한 경우 HttpHeaders 설정 변경 */
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(
                new MediaType("application", "json", StandardCharsets.UTF_8)
        );

        /* 응답 바디 설정 */
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users", users);

        /* 응답 메세지 설정 */
        ResponseMessage responseMessage = new ResponseMessage(
                200, "조회 성공", responseMap
        );

        // 생성자를 이용해 생성하기
        return new ResponseEntity<>(responseMessage, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo){
        /* 응답 헤더 설정 : JSON 응답이 default이기는 하나 변경이 필요한 경우 HttpHeaders 설정 변경 */
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(
                new MediaType("application", "json", StandardCharsets.UTF_8)
        );

        /* 응답 바디 설정 */
        Map<String, Object> responseMap = new HashMap<>();

        UserDTO foundUser = users.stream()
                .filter(user ->user.getNo()==userNo)
                .findFirst()
                .get();
        responseMap.put("user", foundUser);

        /* 응답 메세지 설정 */
        ResponseMessage responseMessage = new ResponseMessage(
                200, "조회 성공", responseMap
        );

        /* 빌더 패턴으로 생성하는 것도 제공하고 있음 */
        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body(new ResponseMessage(200, "조회 성공", responseMap));
    }

    /* 2. PostMapping - create*/
    @PostMapping("/users")
    public ResponseEntity<Void> registUser(@RequestBody UserDTO userDTO){
        /* DB에 저장하는게 아니라 우선 이렇게 저장*/
        int lasUserNo = users.get(users.size()-1).getNo();
        userDTO.setNo(lasUserNo+1);
        users.add(userDTO);

        return ResponseEntity
                .created(URI.create("/entity/users/"+ users.get(users.size()-1).getNo()))
                .build();
    }

    /* 3. PutMapping - update */
    @PutMapping("/users/{userNo}")
    private ResponseEntity<Void> modifyUser(
            @PathVariable int userNo, @RequestBody UserDTO userDTO
    ){
        UserDTO foundUser = users.stream().filter(user ->user.getNo() == userNo)
                .findFirst().get();
        /* 우선 여기에서는 이름과 비밀번호를 변경 */
        foundUser.setPwd(userDTO.getPwd());
        foundUser.setName(userDTO.getName());

        return ResponseEntity.created(URI.create("/entity/users/"+userNo)).build();
    }

    /* 4. DeleteMapping - delete */
    @DeleteMapping("/users/{userNo}")
    public ResponseEntity<Void> removeUser(@PathVariable int userNo){
        UserDTO foundUser = users.stream().filter(user ->user.getNo() == userNo)
                .findFirst().get();

        users.remove(foundUser);
        return ResponseEntity.noContent().build();
    }
}