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

    private int id;
    private String name;
    private String gender;
    private int age;
    private String favorite_scent;
    private String favorite_brand;
    private String usage_frequency;
    private String purchase_budget;
    private String comments;
    private LocalDateTime completion_time;

}
