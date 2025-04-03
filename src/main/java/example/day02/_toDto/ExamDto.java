package example.day02._toDto;

// DTO 목적 : 서로 다른 계층/레이어 간의 이동 객체
// VO 목적 : 수정 불가능한 객체(setter 없음/불변)
// * 사용되는 계층 : 컨트롤러 레이어 ( view <--> controller , controller <--> service )

import lombok.Builder;
import lombok.Data;

@Data
@Builder // 빌더 패턴
public class ExamDto {
    private String id; // 도서식별번호
    private String title; // 도서명
    private int price; // 도서가격
    // (2) dto -> entity 객체로 변환함수
    public ExamEntity1 toEntity() {
        return ExamEntity1.builder()
                .id(this.id)
                .title(this.title)
                .price(this.price)
                .build();
    }
}
