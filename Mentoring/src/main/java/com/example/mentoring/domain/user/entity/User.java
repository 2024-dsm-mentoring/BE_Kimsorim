package com.example.mentoring.domain.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter     // 클래스의 모든 필드에 대한 getter 메소드를 자동 생성
@NoArgsConstructor     // 인자가 없는 기본 생성자를 자동으로 생성
@Entity     // 이 클래스가 데이터베이스 테이블과 매핑됨을 나타냄
public class User {

    @Id     // 이 필드가 테이블의 기본 키임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 기본 키의 값을 생성하도록 설정  Gen ~ ITY 데이터베이스에서
    private Long id;                                        // 자동으로 증가하는 필드를 사용하여 키 값 생성

    private String name;

    private String password;

    @Builder     // 빌더 패턴을 사용하여 객체를 생성할 수 있도록 함
    private User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
