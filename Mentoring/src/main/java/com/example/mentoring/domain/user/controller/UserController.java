package com.example.mentoring.domain.user.controller;

import com.example.mentoring.domain.user.dto.SignUpRequest;
import com.example.mentoring.domain.user.service.UserSignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor     // fianl 로 선언된 모든 필드를 파라미터로 받는 생성자 자동 생성. service 필드에 대한 생성자 생성
@RequestMapping("/user")     // 클래스 레벨에서 기본 URL 경로를 '/user'로 지정. 컨트롤러의 모든 요청 경로 user로 시작
@RestController     // 클래스 내의 메소드들은 JSON / XML 형식의 응답 반한
public class UserController {

    private final UserSignUpService userSignUpService;     // final 로 선언되어 반드시 초기화 되어야 하며, 생성자 주입을 통해 주입

    @ResponseStatus(HttpStatus.CREATED)     // 요청이 성공적으로 처리되면 201 을 응답
    @PostMapping("/signup")     // POST 요청 처리하는 메소드. /user/signup 경로에 대한 POST 요청이 들어오며 메소드 실행
    public void signup(@RequestBody @Valid SignUpRequest request) {     // @Requ 클라이언트 요청 바디에 포함된 JSON 데이터를 SignUpRe 객체로 변환
                                                                        // @Valid 요청 데이터 검증. SignUpRe 클래스에 정의된 유효성 검사 어노테이션에 따라 검증됨
        userSignUpService.execure(request);     // SignUpRe 객체를 UserSignUpService 의 execure 메소드에 전달하여 가입 로직을 수행
    }
}
// 유효성 검증에 실패할 경우 spring 은 자동으로 400 Bad Request 응답을 반환