package example.리포지토리;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExamService {
    // 1. 조작할 엔티티 리포지토리의 인터페이스
    private final ExamEntityRepository examEntityRepository;

    public boolean post(ExamEntity examEntity) {
        System.out.println("ExamService.post");
        System.out.println("examEntity = " + examEntity);
        // 2. 현재 엔티티를 저장하기
        ExamEntity examEntity2 = examEntityRepository.save(examEntity);
        examEntity2.setEng(100);

        return true;
    }

    // - 전체조회
    public List<ExamEntity> get() {
        return examEntityRepository.findAll();
    }

    // - 수정
    public boolean put(ExamEntity examEntity) {
        examEntityRepository.save(examEntity);
        return true;
    }

    // - 수정 : 존재하는 ID만 수정 , .findById(pk값)
    @Transactional
    public boolean put2(ExamEntity examEntity) {
        // 1. id 해당하는 엔티티 찾기
        Optional<ExamEntity> optionalExamEntity = examEntityRepository.findById(examEntity.getId());
        // 2. 만약에 조회한 엔티티가 있으면
        if (optionalExamEntity.isPresent()) {
            // 3. Optional 객체에서 (영속된)엔티티 꺼내기
            ExamEntity entity = optionalExamEntity.get();
            entity.setName(entity.getName());
            entity.setKor(entity.getKor());
            entity.setEng(entity.getEng());
            return true;
        }
        return false;
    }

    public boolean delete(String id) {
        examEntityRepository.deleteById(id);
        System.out.println(examEntityRepository.count());
        System.out.println(examEntityRepository.existsById(id));
        return true;
    }
}
