package com.project.backend.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.project.backend.Entity.Project;


public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("SELECT p FROM Project p INNER JOIN p.user u WHERE u.email = :email")
    List<Project> findProjectsByUserEmail(@Param("email") String email);
    
    Optional<Project> findByProjectStatement(String projectStatement);
}
