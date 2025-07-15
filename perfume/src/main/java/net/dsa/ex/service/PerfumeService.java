package net.dsa.ex.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dsa.ex.dto.PerfumeDTO;
import net.dsa.ex.entity.PerfumeEntity;
import net.dsa.ex.repository.PerfumeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class PerfumeService {

    private final PerfumeRepository pr;

    // 저장
    public void save(PerfumeDTO dto) {

        PerfumeEntity entity = PerfumeEntity.builder()
                .name(dto.getName())
                .gender(dto.getGender())
                .age(dto.getAge())
                .favoriteScent(dto.getFavoriteScent())
                .favoriteBrand(dto.getFavoriteBrand())
                .usageFrequency(dto.getUsageFrequency())
                .purchaseBudget(dto.getPurchaseBudget())
                .comments(dto.getComments())
                .build();

        pr.save(entity);
    }

    // 전체 조회
    public List<PerfumeDTO> findAll() {

        List<PerfumeEntity> entityList = pr.findAll(Sort.by(Order.desc("gender"), Order.asc("age"), Order.desc("completionTime")));
        List<PerfumeDTO> perfumes = new ArrayList<>();

        for(PerfumeEntity entity : entityList) {
            PerfumeDTO dto = new PerfumeDTO();

            dto.setNo(entity.getNo());
            dto.setName(entity.getName());
            dto.setGender(entity.getGender());
            dto.setAge(entity.getAge());
            dto.setFavoriteScent(entity.getFavoriteScent());
            dto.setFavoriteBrand(entity.getFavoriteBrand());
            dto.setUsageFrequency(entity.getUsageFrequency());
            dto.setPurchaseBudget(entity.getPurchaseBudget());
            dto.setComments(entity.getComments());
            dto.setCompletionTime(entity.getCompletionTime());

            perfumes.add(dto);
        }

        return perfumes;
    }

    // 여자 카운트
    public int countFemale() {
        return pr.countByGender("여성");
    }
}
