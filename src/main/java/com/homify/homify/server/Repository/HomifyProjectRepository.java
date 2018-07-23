
package com.homify.homify.server.Repository;

import com.homify.homify.business.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HomifyProjectRepository extends JpaRepository<Project,String> {

    @Query("Delete from Project proj where proj.title='title'")
    void deleteByProject(String title);

    @Query("select proj from Project proj where proj.owner='owner'")
    Iterable<Project> findOne(String owner);

    @Query("SELECT proj FROM Project proj WHERE proj.duration='duration'")
    Iterable<Project> findAllByGivenPeriod(String duration);

    @Query("select proj from Project proj where proj.type='type'")
    Iterable<Project> findAllByType(String type);

    @Query("select proj from Project proj where proj.title='title'")
    Project findOneByTitle(String title);
}

