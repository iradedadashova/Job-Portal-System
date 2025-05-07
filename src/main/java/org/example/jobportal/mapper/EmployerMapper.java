package org.example.jobportal.mapper;

import org.example.jobportal.Model.DTO.Request.EmployerRequest;
import org.example.jobportal.Model.DTO.Response.EmployerResponse;
import org.example.jobportal.Model.Entity.Employer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vacancies", ignore = true)
    Employer toEntity(EmployerRequest request);

    EmployerResponse toResponse(Employer employer);
}
