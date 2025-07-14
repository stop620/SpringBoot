package net.dsa.ex.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dsa.ex.dto.PerfumeDTO;
import net.dsa.ex.entity.PerfumeEntity;
import net.dsa.ex.repository.PerfumeRepository;
import org.springframework.stereotype.Service;

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
}
