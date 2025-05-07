package org.example.jobportal.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.example.jobportal.Model.DTO.Request.VacanciesRequest;
import org.example.jobportal.Model.DTO.Response.VacanciesResponse;
import org.example.jobportal.Model.Entity.Vacancies;
import org.example.jobportal.Repository.VacanciesRepository;
import org.example.jobportal.Service.VacanciesService;
import org.example.jobportal.mapper.VacanciesMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("v1/vacancy")
@RequiredArgsConstructor
public class VacanciesController {


    private final VacanciesService vacanciesService;
    private final VacanciesMapper vacanciesMapper;
    private final VacanciesRepository vacanciesRepository;

    @PostMapping
    public VacanciesResponse createVacancy(VacanciesRequest request) {
        Vacancies vacancy = vacanciesMapper.toEntity(request);
        Vacancies savedVacancy = vacanciesRepository.save(vacancy);
        return vacanciesMapper.toResponse(savedVacancy);}

        @PutMapping("/{id}")
        public ResponseEntity<VacanciesResponse> updateVacancy (@PathVariable Long id, @RequestBody VacanciesRequest
        request) {
            VacanciesResponse vacancyResponse = vacanciesService.updateVacancy(id, request);
            return new ResponseEntity<>(vacancyResponse, HttpStatus.OK);

        }
        @GetMapping("/{id}")
        public ResponseEntity<VacanciesResponse> getVacancy (@PathVariable Long id){
            VacanciesResponse vacancyResponse = vacanciesService.getVacancy(id);
            return new ResponseEntity<>(vacancyResponse, HttpStatus.OK);
        }

        @GetMapping
        public ResponseEntity<List<VacanciesResponse>> getAllVacancies () {
            List<VacanciesResponse> vacancyResponses = vacanciesService.getAllVacancies();
            return new ResponseEntity<>(vacancyResponses, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteVacancy (@PathVariable Long id){
            vacanciesService.deleteVacancy(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

