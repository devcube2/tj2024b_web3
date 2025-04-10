package example.day04.task5.model.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

// - DB테이블의 레코드 생성날짜와 수정날짜를 감지하는 엔티티
// - AppStart 클래스에서 '@EnableJpaAuditing' 활성화 한다.
@MappedSuperclass // 해당 클래스는 일반 엔티티가 아닌 상속엔티티로 사용
@EntityListeners (AuditingEntityListener.class) // 해당 클래스의 멤버 변수들은 JPA 감지 대상
public class BaseTime {
    // 1. 엔티티/레코드 의 영속/생성 날짜/시간 자동 주입
    @CreatedDate
    protected LocalDateTime createdDate; // 회원가입날짜 , 제품등록일 , 주문일

    // 2. 엔티티/레코드 의 수정 날짜/시간 자동 주입
    @LastModifiedDate
    protected LocalDateTime modifiedDate; // 회원수정날짜 , 제품수정일 , 주문수정일
}

