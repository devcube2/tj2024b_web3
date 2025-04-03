package example.day03._과제3;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public boolean 수강생등록(StudentDto studentDto) {
        CourseEntity courseEntity = courseRepository.findById(studentDto.get과정번호())
                .orElseThrow(() -> new IllegalArgumentException("과정을 찾을 수 없습니다."));
        studentRepository.save(studentDto.toEntity(courseEntity));
        return true;
    }

    public List<StudentDto> 수강생조회(int 과정번호) {
        System.out.println("StudentService.수강생조회");
        CourseEntity courseEntity = courseRepository.findById(과정번호)
                .orElseThrow(() -> new IllegalArgumentException("과정을 찾을 수 없습니다."));

        List<StudentEntity> studentEntityList = courseEntity.getStudentEntityList();

        return studentEntityList
                .stream()
                .map(StudentEntity::toDto)
                .toList();
    }
}
