package com.example.mentoring.domain.user.repository;

import com.example.mentoring.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
    // 커스텀 쿼리 메서드
    // Optional<User> 를 반환하며, 주어진 이름에 해당하는 user 엔티티를 찾을 수
    // 있는 경우 그 값을 반환하고, 찾을 수 없는 경우 빈 'Optional' 을 반환
}
