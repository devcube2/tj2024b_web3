package example.day04.task5.controller;

import example.day04.task5.model.dto.SupplyDto;
import example.day04.task5.service.SupplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/day04/task4")
public class SupplyController {
    private final SupplyService supplyService;

    @PostMapping
    public boolean 비품등록(@RequestBody SupplyDto supplyDto) {
        System.out.println("SupplyController.비품등록");
        System.out.println("supplyDto = " + supplyDto);
        return supplyService.비품등록(supplyDto);
    }

    @GetMapping
    public List<SupplyDto> 비품전체조회() {
        System.out.println("SupplyController.비품전체조회");
        return supplyService.전체비품조회();
    }

    @GetMapping("/view")
    public SupplyDto 비품개별조회(@RequestParam int id) {
        System.out.println("SupplyController.비품개별조회");
        System.out.println("id = " + id);
        return supplyService.개별비품조회(id);
    }

    @PutMapping
    public boolean 비품수정(@RequestBody SupplyDto supplyDto) {
        System.out.println("SupplyController.비품수정");
        System.out.println("supplyDto = " + supplyDto);
        return supplyService.비품수정(supplyDto);
    }

    @DeleteMapping
    public boolean 비품삭제(@RequestParam int id) {
        System.out.println("SupplyController.비품삭제");
        System.out.println("id = " + id);
        return supplyService.비품삭제(id);
    }

    @GetMapping("/page")
    public List<SupplyDto> 비품목록페이지조회(
            @RequestParam(defaultValue = "1") int page, // 현재 조회할 페이지 번호
            @RequestParam(defaultValue = "3") int size) { // 페이지당 자료 개수
        return supplyService.비품목록페이지조회(page, size);
    }
}
