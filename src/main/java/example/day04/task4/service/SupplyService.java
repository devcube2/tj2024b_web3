package example.day04.task4.service;

import example.day04.task4.model.dto.SupplyDto;
import example.day04.task4.model.entity.SupplyEntity;
import example.day04.task4.model.repository.SupplyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SupplyService {
    private final SupplyRepository supplyRepository;

    public boolean 비품등록(SupplyDto supplyDto) {
        supplyRepository.save(supplyDto.toEntity());
        return true;
    }

    public List<SupplyDto> 전체비품조회() {
        List<SupplyEntity> supplyEntityList = supplyRepository.findAll();
        return supplyEntityList
                .stream()
                .map(SupplyEntity::toDto)
                .toList();
    }

    public SupplyDto 개별비품조회(int id) {
        SupplyEntity supplyEntity = supplyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("비품을 찾을 수 없습니다."));
        return supplyEntity.toDto();
    }

    public boolean 비품수정(SupplyDto supplyDto) {
        SupplyEntity supplyEntity = supplyRepository.findById(supplyDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("비품을 찾을 수 없습니다."));
        supplyEntity.setName(supplyDto.getName());
        supplyEntity.setDescription(supplyDto.getDescription());
        supplyEntity.setQuantity(supplyDto.getQuantity());
        return true;
    }

    public boolean 비품삭제(int id) {
        SupplyEntity supplyEntity = supplyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("비품을 찾을 수 없습니다."));
        supplyRepository.deleteById(id);
        return true;
    }

    public List<SupplyDto> 비품목록페이지조회(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page-1, size, Sort.by(Sort.Direction.DESC, "id"));
        return supplyRepository.findAll(pageRequest).stream()
                .map(SupplyEntity::toDto)
                .toList();
    }
}
