package example.day02._toDto;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ExamService {
    private final ExamEntity1Repository examEntity1Repository;

    public boolean post(ExamDto examDto) {
        // 1. DTO를 영속성(객체<-->DB매핑 상태)을 부여 할수 없고 DTO를 ENTITY 변환
        // * 비영속성
        ExamEntity1 examEntity1 = examDto.toEntity();
        // * 영속성
        examEntity1Repository.save(examEntity1);
        return true;
    }
    // entity --> dto 변환
    public List<ExamDto> get() {
        // 1. 모든 영속된/레코드 조회한다.
        List<ExamEntity1> entity1List = examEntity1Repository.findAll();
        // 2. 모든 영속된 엔티티 대신에 DTO를 반환한다. 스트림
//        return entity1List.stream()
//                .map(ExamEntity1::toDto) // map
//                .collect(Collectors.toList());
        // 2. 심플
        List<ExamDto> examDtos = new ArrayList<>();
        for (int i = 0; i < entity1List.size(); i++) {
            ExamEntity1 entity1 = entity1List.get(i);
            ExamDto examDto = entity1.toDto();
            examDtos.add(examDto);
        }
        return examDtos;
    }
}
