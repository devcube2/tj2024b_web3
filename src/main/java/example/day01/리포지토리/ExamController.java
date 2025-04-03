package example.day01.리포지토리;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day01/jpa")
@RequiredArgsConstructor
public class ExamController {
    private final ExamService examService;
    // 1. 등록
    @PostMapping
    public boolean post(@RequestBody ExamEntity examEntity) {
        return examService.post(examEntity);
    }

    // 2. 전체 조회
    @GetMapping
    public List<ExamEntity> get() {
        return examService.get();
    }

    // 3. 수정
    @PutMapping
    public boolean put(@RequestBody ExamEntity examEntity) {
        return examService.put(examEntity);
    }

    // 4. 삭제
    @DeleteMapping
    public boolean delete(@RequestParam String id) {
        return examService.delete(id);
    }
}
