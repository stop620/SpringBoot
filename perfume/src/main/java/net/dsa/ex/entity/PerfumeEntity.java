package net.dsa.ex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "perfume")
public class PerfumeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    private String name;
    private String gender;
    private int age;
    private String favorite_scent;
    private String favorite_brand;
    private String usage_frequency;
    private String purchase_budget;
    private String comments;

    @CreationTimestamp
    private LocalDateTime completion_time;
}
