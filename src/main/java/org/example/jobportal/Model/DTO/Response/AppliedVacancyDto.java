package org.example.jobportal.Model.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppliedVacancyDto {
    private Long vacancyId;
    private String vacancyName;
    private String companyEmail;
    private String appliedDate;
}
