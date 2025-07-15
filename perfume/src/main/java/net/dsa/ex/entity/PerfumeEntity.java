package net.dsa.ex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "perfume")
@EntityListeners(AuditingEntityListener.class)
public class PerfumeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    private String name;
    private String gender;
    private int age;

    @Column(name = "favorite_scent")
    private String favoriteScent;

    @Column(name = "favorite_brand")
    private String favoriteBrand;

    @Column(name = "usage_frequency")
    private String usageFrequency;

    @Column(name = "purchase_budget")
    private String purchaseBudget;

    private String comments;

    @CreatedDate
    private LocalDateTime completionTime;
}
