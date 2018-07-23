package com.homify.homify.server.reference.Project;

import com.homify.homify.business.Project;
import com.homify.homify.server.Repository.HomifyProjectRepository;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service("projectJDO")
@Transactional
public class ProjectJDOImpl implements ProjectJDO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    HomifyProjectRepository homifyProjectRepository;

    //---- Create Project ----
    public void createProject(Project project) {
        Assert.notNull(project, "The entity must not be null!");
        this.homifyProjectRepository.save(project);
    }

    //---- Delete Project ----
    public void deleteByProject(String project) {
        homifyProjectRepository.deleteByProject(project);
    }

    //---- Update Project ----
    public Project update(String title, Project project) throws BadHttpRequest {
        if (exists(title)) {
            project.setTitle(title);
            return homifyProjectRepository.save(project);
        } else {
            throw new BadHttpRequest();
        }
    }


    //------  Display One Project----
    public Project findOneByTitle(String title){
        Assert.notNull(title, "The entity must not be null!");
        return  homifyProjectRepository.findOneByTitle(title);
    }


    //------  All Projecct for given period----
    public Iterable<Project> findAll(String duration){
        return homifyProjectRepository.findAllByGivenPeriod(duration);
    }

    //------  All Project by type----
    public Iterable<Project> findAllByType(String type){
        return homifyProjectRepository.findAllByType(type);
    }

    //------  Display Project by Professional----
    public Iterable<Project> findProjectByProfessional(String owner){
        Assert.notNull(owner, "The entity must not be null!");
        return  homifyProjectRepository.findOne(owner);
    }

    //--check if userName exists--
    public boolean exists(java.lang.String userName){
        Assert.notNull(userName, "The entity does not exist!");
        return (this.entityManager.contains(userName) ? true : false);
    }
}
