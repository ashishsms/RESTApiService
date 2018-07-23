package com.homify.homify.server.Repository;

import com.homify.homify.business.Professional;
import com.homify.homify.business.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(path = "/professionals")
@Repository
public interface HomifyRepository extends JpaRepository<Professional,String> {

    @Query("Delete from Professional prof where prof.userName='userName'")
    void deleteByUserName(String userName);

    @Query("select prof from Professional prof where prof.userName='userName'")
    Professional findOne(Class<Professional> professionalClass, String userName);

   /* @Query("select proj from Project proj where proj.title='title'")
    Project findOneByTitle(Project projectClass, String title);*/

    @Query("SELECT prof FROM Professional prof WHERE   From_date >= 'fromDate' AND To_date <= 'toDate'")
    Iterable<Professional> findAllByGivenPeriod(String fromDate, String toDate);

    @Query("SELECT prof FROM Professional prof WHERE   Latitude = 'latitude' AND Longitude = 'longitude'")
    Iterable<Professional> findAllByLatitudeLongitude(String latitude, String longitude);

    @Query("select prof from Professional prof where prof.type='type'")
    Iterable<Professional> findAllByType(String type);
}
