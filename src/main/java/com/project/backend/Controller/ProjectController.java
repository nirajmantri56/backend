package com.project.backend.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.backend.Entity.Project;
import com.project.backend.Entity.User;
import com.project.backend.Repo.ProjectRepository;
import com.project.backend.Repo.UserRepo;
import com.project.backend.Service.impl.ProjectServiceImpl;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping
public class ProjectController {
    
    private final ProjectRepository projectRepository;
    private final UserRepo userRepo;
    private final ProjectServiceImpl projectServiceImpl;

    @Autowired
    public ProjectController(ProjectRepository projectRepository, UserRepo userRepo, ProjectServiceImpl projectServiceImpl) {
        this.projectRepository = projectRepository;
        this.userRepo = userRepo;
        this.projectServiceImpl = projectServiceImpl;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @Transactional
    @PostMapping("/add/{email}")
    public ResponseEntity<?> addProject(@PathVariable String email, @RequestBody Project project) {
        try {
            Optional<User> userOptional = userRepo.findByEmail(email);

            if(userOptional.isPresent()) {
                User user = userOptional.get();
                project.setUser(user);

                Project savedProject = projectRepository.save(project);
                return ResponseEntity.ok(savedProject);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with email: " + email);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    @GetMapping("/uploaded-by/{email}")
    public ResponseEntity<List<Project>> getProjectsByUserEmail(@PathVariable String email) {
        return ResponseEntity.ok(projectRepository.findProjectsByUserEmail(email));
    }

    @GetMapping("/uploaded/all")
    public ResponseEntity<List<Project>> getAllProjects(){
        List<Project> projects = projectServiceImpl.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/uploaded/{projectStatement}")
    public ResponseEntity<Optional<Project>> getProjectByProjectStatement(@PathVariable String projectStatement) {
        Optional<Project> project = projectServiceImpl.getProjectByProjectStatement(projectStatement);
        return ResponseEntity.ok(project);
    }
}
