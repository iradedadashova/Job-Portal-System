package org.example.jobportal.Model.DTO.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VacanciesRequest {
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String email;
    private Long categoryId;
    private Long employerId;
}
