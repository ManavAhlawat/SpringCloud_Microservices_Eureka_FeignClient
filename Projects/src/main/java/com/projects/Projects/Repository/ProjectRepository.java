package com.projects.Projects.Repository;

import com.projects.Projects.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Project findByProjectName(String projectName);
}
