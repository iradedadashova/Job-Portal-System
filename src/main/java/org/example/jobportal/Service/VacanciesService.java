package org.example.jobportal.Service;

import lombok.RequiredArgsConstructor;
import org.example.jobportal.Model.DTO.Request.VacanciesRequest;
import org.example.jobportal.Model.DTO.Response.VacanciesResponse;
import org.example.jobportal.Model.Entity.Vacancies;
import org.example.jobportal.Repository.VacanciesRepository;
import org.example.jobportal.mapper.VacanciesMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VacanciesService {

    private final VacanciesRepository vacancyRepository;
    private final VacanciesMapper vacancyMapper;

    public VacanciesResponse createVacancy(VacanciesRequest request) {
        Vacancies vacancy = vacancyMapper.toEntity(request);
        Vacancies savedVacancy = vacancyRepository.save(vacancy);
        return vacancyMapper.toResponse(savedVacancy);
    }

    public VacanciesResponse updateVacancy(Long id, VacanciesRequest request) {
        Vacancies existingVacancy = vacancyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vacancy not found with id: " + id));

        vacancyMapper.updateEntity(existingVacancy, request);
        Vacancies updatedVacancy = vacancyRepository.save(existingVacancy);
        return vacancyMapper.toResponse(updatedVacancy);
    }

    public VacanciesResponse getVacancy(Long id) {
        Vacancies vacancy = vacancyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vacancy not found with id: " + id));
        return vacancyMapper.toResponse(vacancy);
    }

    public List<VacanciesResponse> getAllVacancies() {
        List<Vacancies> vacancies = vacancyRepository.findAll();
        return vacancies.stream()
                .map(vacancyMapper::toResponse)
                .collect(Collectors.toList());
    }

    public void deleteVacancy(Long id) {
        Vacancies existingVacancy = vacancyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vacancy not found with id: " + id));
        vacancyRepository.delete(existingVacancy);
    }

}
