package example.day03._과제3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/day03/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public boolean 수강생등록(@RequestBody StudentDto studentDto) {
        System.out.println("StudentController.학생등록");
        System.out.println("studentDto = " + studentDto);
        return studentService.수강생등록(studentDto);
    }

    @GetMapping
    public List<StudentDto> 수강생조회(@RequestParam int 과정번호) {
        System.out.println("StudentController.수강생조회");
        return studentService.수강생조회(과정번호);
    }
}
