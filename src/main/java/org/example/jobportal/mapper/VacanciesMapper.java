package org.example.jobportal.mapper;

import org.example.jobportal.Model.DTO.Request.VacanciesRequest;
import org.example.jobportal.Model.DTO.Response.VacanciesResponse;
import org.example.jobportal.Model.Entity.Category;
import org.example.jobportal.Model.Entity.Employer;
import org.example.jobportal.Model.Entity.Vacancies;
import org.example.jobportal.Repository.CategoryRepository;
import org.example.jobportal.Repository.EmployerRepository;
import org.springframework.stereotype.Component;

@Component
public class VacanciesMapper {
    private final CategoryRepository categoryRepository;
    private final EmployerRepository employerRepository;

    public VacanciesMapper(CategoryRepository categoryRepository, EmployerRepository employerRepository) {
        this.categoryRepository = categoryRepository;
        this.employerRepository = employerRepository;
    }

    // VacancyRequest -> Vacancy
    public Vacancies toEntity(VacanciesRequest request) {
        if (request == null) {
            return null;
        }

        Vacancies vacancy = new Vacancies();
        vacancy.setName(request.getName());
        vacancy.setDescription(request.getDescription());
        vacancy.setStartDate(request.getStartDate());
        vacancy.setEndDate(request.getEndDate());
        vacancy.setEmail(request.getEmail());

        if (request.getCategoryId() != null) {
            Category category = categoryRepository.findById(request.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            vacancy.setCategory(category);
        }
        if (request.getEmployerId() != null) {
            Employer employer = employerRepository.findById(request.getEmployerId())
                    .orElseThrow(() -> new RuntimeException("Employer not found"));
            vacancy.setEmployer(employer);
        }

        return vacancy;
    }

    public VacanciesResponse toResponse(Vacancies vacancy) {
        if (vacancy == null) {
            return null;
        }
        VacanciesResponse response = new VacanciesResponse();
        response.setId(vacancy.getId());
        response.setName(vacancy.getName());
        response.setDescription(vacancy.getDescription());
        response.setStartDate(vacancy.getStartDate());
        response.setEndDate(vacancy.getEndDate());
        response.setEmail(vacancy.getEmail());
        if (vacancy.getCategory() != null) {
            response.setCategoryName(vacancy.getCategory().getCategoryName());
        }

        if (vacancy.getEmployer() != null) {
            response.setEmployerName(vacancy.getEmployer().getName());
        }

        return response;
    }

    public void updateEntity(Vacancies vacancy, VacanciesRequest request) {
        if (request == null) {
            return;
        }
        vacancy.setName(request.getName());
        vacancy.setDescription(request.getDescription());
        vacancy.setStartDate(request.getStartDate());
        vacancy.setEndDate(request.getEndDate());
        vacancy.setEmail(request.getEmail());

        if (request.getCategoryId() != null) {
            Category category = categoryRepository.findById(request.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            vacancy.setCategory(category);
        }

        if (request.getEmployerId() != null) {
            Employer employer = employerRepository.findById(request.getEmployerId())
                    .orElseThrow(() -> new RuntimeException("Employer not found"));
            vacancy.setEmployer(employer);
        }

    }
}