package org.example.jobportal.Repository;

import org.example.jobportal.Model.Entity.Vacancies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacanciesRepository extends JpaRepository<Vacancies, Long> {
}
