package com.homify.homify.server.reference.Project;

import com.homify.homify.business.Project;
import javassist.tools.web.BadHttpRequest;

public interface ProjectJDO {

    public void createProject(Project project) ;

   public void deleteByProject(String title);

    public Project update(String title, Project project) throws BadHttpRequest;

    public com.homify.homify.business.Project findOneByTitle(String title);

    public Iterable<Project> findAll(String duration);

    public Iterable<Project> findAllByType(String type);

    public Iterable<Project> findProjectByProfessional(String userName);
}
