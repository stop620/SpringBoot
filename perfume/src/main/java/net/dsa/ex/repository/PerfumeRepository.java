package net.dsa.ex.repository;

import net.dsa.ex.entity.PerfumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfumeRepository extends JpaRepository<PerfumeEntity, Integer> {
}
