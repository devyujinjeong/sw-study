package com.dbwls.springsecurity.command.service;

import com.dbwls.springsecurity.command.dto.UserCreateRequest;
import com.dbwls.springsecurity.command.entity.User;
import com.dbwls.springsecurity.command.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserCommandService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(UserCreateRequest request) {
        // 중복 회원 체크 로직 등 추가 기능
        User user = modelMapper.map(request,User.class);
        // 패스워드 암호화 시켜서 저정하기
        user.setEncodedPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
    }
}
