package com.adrian.demojpa.infrastructure.repository;

import java.util.List;
import org.springframework.stereotype.Service;

import com.adrian.demojpa.application.service.ProjectService;
import com.adrian.demojpa.domain.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public boolean eliminarPorId(long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
