package com.example.mentoring.domain.user.service;

import com.example.mentoring.domain.user.dto.SignUpRequest;
import com.example.mentoring.domain.user.entity.User;
import com.example.mentoring.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor     // final 필드나 @NonNull 필드에 대해 생성자 자동 생성
@Service     // 서비스 계층의 컴포넌트임을 나타냄. 이 클래스를 서비스 빈으로 등록하여 관리하게 함
public class UserSignUpService {
    private final UserRepository userRepository;     // userRepository 인터페이스를 주입받기 위한 필드
                                                     // final 키워드로 선언되어 있어 생성자를 통해 초기화되어야 함
    @Transactional     // 트랜잭션 범위 내에서 실행됨. 성공석으로 왼료되면 트랜잭션이 커밋되고, 예외가 발생하면 롤백
    public void execure(SignUpRequest request) {     // SignUpRe 객체를 인자로 받아 사용자 정보를 처리하는 메소드

        User user = User.builder()     // 빌더 패턴을 사용해 User 객체 생성
                .name(request.getName())     // SignUpRe 객체에서 name 과 password 를 가져와 User 객체를 만듦
                .password(request.getPassword())
                .build();

        userRepository.save(user);     // 생성된 User 객체를 데이터베이스에 저장
    }
}
