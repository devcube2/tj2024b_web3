package example.day03._과제3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/day03/course")
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public boolean 과정등록(@RequestBody CourseDto courseDto) {
        System.out.println("CourseController.과정등록");
        System.out.println("courseDto = " + courseDto);
        return courseService.과정등록(courseDto);
    }

    @GetMapping
    public List<CourseDto> 과정전체조회() {
        System.out.println("CourseController.과정전체조회");
        return courseService.과정전체조회();
    }
}
