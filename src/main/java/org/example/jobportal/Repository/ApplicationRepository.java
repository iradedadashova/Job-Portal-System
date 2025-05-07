package org.example.jobportal.Repository;

import org.example.jobportal.Model.Entity.Application;
import org.example.jobportal.Model.Entity.Category;
import org.example.jobportal.Model.Entity.User;
import org.example.jobportal.Model.Entity.Vacancies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    boolean existsByUserAndVacancy(User user, Vacancies vacancy);
    List<Application> findAllByUser(User user);
}
