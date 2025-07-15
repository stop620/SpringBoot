package net.dsa.ex.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dsa.ex.dto.PerfumeDTO;
import net.dsa.ex.entity.PerfumeEntity;
import net.dsa.ex.repository.PerfumeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class PerfumeService {

    private final PerfumeRepository pr;

    // function
    public void save(PerfumeDTO dto) {

        PerfumeEntity entity = PerfumeEntity.builder()
                .name(dto.getName())
                .gender(dto.getGender())
                .age(dto.getAge())
                .favorite_scent(dto.getFavorite_scent())
                .favorite_brand(dto.getFavorite_brand())
                .usage_frequency(dto.getUsage_frequency())
                .purchase_budget(dto.getPurchase_budget())
                .comments(dto.getComments())
                .build();

        pr.save(entity);
    }

    public List<PerfumeDTO> findAll() {

        List<PerfumeEntity> entityList = pr.findAll();
        List<PerfumeDTO> perfumes = new ArrayList<>();

        for(PerfumeEntity entity : entityList) {
            PerfumeDTO dto = new PerfumeDTO();

            dto.setNo(entity.getNo());
            dto.setName(entity.getName());
            dto.setGender(entity.getGender());
            dto.setAge(entity.getAge());
            dto.setFavorite_scent(entity.getFavorite_scent());
            dto.setFavorite_brand(entity.getFavorite_brand());
            dto.setUsage_frequency(entity.getUsage_frequency());
            dto.setPurchase_budget(entity.getPurchase_budget());
            dto.setComments(entity.getComments());
            dto.setCompletion_time(entity.getCompletion_time());

            perfumes.add(dto);
        }

        return perfumes;
    }
}
