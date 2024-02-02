package io.yueqi.pmtool.controller;


import io.yueqi.pmtool.dto.Project;
import io.yueqi.pmtool.services.MapValidationErrorService;
import io.yueqi.pmtool.services.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/project")


public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping(value = "")
    public ResponseEntity<Project> creatNewProject (@Valid @RequestBody Project project, BindingResult result){

        if(result.hasErrors()){
            Map<String,String> errorMap = new HashMap<>();
            result.getFieldErrors().forEach((e) -> errorMap.put(e.getField(),e.getDefaultMessage()));

            return new ResponseEntity<Map<String, String>(errorMap, HttpStatus.BAD_REQUEST);

        }

        Project newProject = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Entity>(newProject, HttpStatus.CREATED);
    }
}
