package org.example.jobportal.Service;


import lombok.RequiredArgsConstructor;
import org.example.jobportal.Model.DTO.Response.ApplicationResponse;
import org.example.jobportal.Model.DTO.Response.AppliedVacancyDto;
import org.example.jobportal.Model.Entity.Application;
import org.example.jobportal.Model.Entity.User;
import org.example.jobportal.Model.Entity.Vacancies;
import org.example.jobportal.Repository.ApplicationRepository;
import org.example.jobportal.Repository.VacanciesRepository;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final VacanciesRepository vacancyRepository;

    public ApplicationResponse applyToVacancy(Long vacancyId, User user) {
        Vacancies vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(() -> new RuntimeException("Vakansiya tapılmadı"));

        boolean alreadyApplied = applicationRepository.existsByUserAndVacancy(user, vacancy);
        if (alreadyApplied) {
            throw new RuntimeException("Bu vakansiyaya artıq müraciət etmisiniz");
        }

        Application application = new Application();
        application.setUser(user);
        application.setVacancy(vacancy);
        application.setAppliedAt(LocalDateTime.now());
        applicationRepository.save(application);

        return new ApplicationResponse(
                "CV göndərmək üçün email ünvanını kopyalayın",
                vacancy.getName(),
                vacancy.getEmail()
        );
    }

    public List<AppliedVacancyDto> getMyApplications(User user) {
        List<Application> applications = applicationRepository.findAllByUser(user);

        return applications.stream()
                .map(app -> new AppliedVacancyDto(
                        app.getVacancy().getId(),
                        app.getVacancy().getName(),
                        app.getVacancy().getEmail(),
                        app.getAppliedAt().toString()
                )).collect(Collectors.toList());
    }
}
