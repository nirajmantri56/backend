package com.project.backend.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.backend.Entity.Project;
import com.project.backend.Repo.ProjectRepository;

@Service
public class ProjectServiceImpl {
    
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectByProjectStatement(String projectStatement){
        return projectRepository.findByProjectStatement(projectStatement);
    }
}
