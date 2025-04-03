package example.day03._과제3;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CourseService {
    private final CourseRepository courseRepository;

    public boolean 과정등록(CourseDto courseDto) {
        System.out.println("CourseService.과정등록");
        System.out.println("courseDto = " + courseDto);
        courseRepository.save(courseDto.toEntity());
        return true;
    }

    public List<CourseDto> 과정전체조회() {
        System.out.println("CourseService.과정전체조회");
        List<CourseEntity> courseEntityList = courseRepository.findAll();
        return courseEntityList
                .stream()
                .map(entity -> entity.toDto())
//                .map(CourseEntity::toDto)
                .collect(Collectors.toList());
    }
}
