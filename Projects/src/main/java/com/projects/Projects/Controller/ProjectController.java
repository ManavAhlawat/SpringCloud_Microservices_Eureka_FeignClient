package com.projects.Projects.Controller;

import com.projects.Projects.Entity.Project;
import com.projects.Projects.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping("/projects")
    public List<Project> getProjects(){
        return service.getProjects();
    }

    @GetMapping("/projectByID/{projectCode}")
    public Project findProjectById(@PathVariable int projectCode){
        return service.getProjectById(projectCode);
    }

    @GetMapping("/project/{projectName}")
    public Project findProjectByName(@PathVariable String projectName){
        return service.getProjectByName(projectName);
    }

    @PutMapping("/updateProject")
    public Project updateProject(@RequestBody Project project){
        return service.updateProject(project);
    }

    @DeleteMapping("/deleteProject/{projectCode}")
    public String deleteProject(@PathVariable int projectCode){
        return service.deleteProject(projectCode);
    }
}
