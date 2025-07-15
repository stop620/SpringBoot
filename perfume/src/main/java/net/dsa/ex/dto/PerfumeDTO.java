package net.dsa.ex.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PerfumeDTO {

    private int no;
    private String name;
    private String gender;
    private int age;
    private String favoriteScent;
    private String favoriteBrand;
    private String usageFrequency;
    private String purchaseBudget;
    private String comments;
    private LocalDateTime completionTime;

}
