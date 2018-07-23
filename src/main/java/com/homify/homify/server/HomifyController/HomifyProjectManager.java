package com.homify.homify.server.HomifyController;

import com.homify.homify.business.Project;
import com.homify.homify.server.reference.Project.ProjectJDO;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/project")
public class HomifyProjectManager {

    @Autowired
    private ProjectJDO projectJDO;

    public HomifyProjectManager() {
    }

    //---- Create Project ----
    @PostMapping(consumes = "application/json")
    public void createProject(@RequestBody Project project) {
        projectJDO.createProject(project);
    }

    //---- Delete Project ----

    @DeleteMapping(path = "/{title}")
    public void deleteByTitle(@PathVariable("title") String title) {
        Assert.notNull(title, "The entity must not be null!");
        projectJDO.deleteByProject(title);
    }


    //---- Update Project ----
    @PutMapping(path = "/{title}")
    public Project update(@PathVariable("title") String title, @RequestBody Project project) throws BadHttpRequest {
        return projectJDO.update(title,project);
    }

    //------  All Project for given period----
    @GetMapping(path = "/{duration}")
    public Iterable<Project> findAll(@PathVariable("duration") String duration) {
        return projectJDO.findAll(duration);
    }

    //------  Display Project by  Professional----
    @GetMapping(path = "/{owner}")
    public Iterable<Project> find(@PathVariable("owner") String owner) {
        return projectJDO.findProjectByProfessional(owner);
    }


    //------  All Project by type----
    @GetMapping(path = "/{type}")
    public Iterable<Project> findAllByType(@PathVariable("type") String type) {
        return projectJDO.findAllByType(type);
    }

    //------  Display One Project----
    @GetMapping(path = "/{title}")
    public Project findOneByTitle(@PathVariable("title") String title){
        Assert.notNull(title, "The entity must not be null!");
        return  projectJDO.findOneByTitle(title);
    }
}


