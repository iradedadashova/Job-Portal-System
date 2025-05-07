package org.example.jobportal.mapper;

import org.example.jobportal.Model.Entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.example.jobportal.Model.DTO.Request.CategoryRequest;
import org.example.jobportal.Model.DTO.Response.CategoryResponse;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vacancies", ignore = true)
    Category toEntity(CategoryRequest request);

    CategoryResponse toResponse(Category category);

}
