package org.example.jobportal.Model.DTO.Response;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VacanciesResponse {
    private Long id;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String email;
    private String categoryName;
    private String employerName;
}
