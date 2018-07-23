package com.homify.homify.server.reference.Professional;

import com.homify.homify.business.Professional;
import com.homify.homify.server.Repository.HomifyRepository;
import com.homify.homify.server.reference.Professional.ProfessionalJDO;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service("professionalJDO")
@Transactional
public class ProfessionalJDOImpl implements ProfessionalJDO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    HomifyRepository homifyProfessionalRepository;

    //---- Create Professional ----
    public void createProfessional(Professional professional) {
        Assert.notNull(professional, "The entity must not be null!");
        this.homifyProfessionalRepository.save(professional);
    }

    //---- Delete Professional ----
    public void deleteByUserName(String username) {
        homifyProfessionalRepository.deleteByUserName(username);
    }

    //---- Update Professional ----
    public Professional update(String username, Professional professional) throws BadHttpRequest {
        if (exists(username)) {
            professional.setUserName(username);
            return homifyProfessionalRepository.save(professional);
        } else {
            throw new BadHttpRequest();
        }
    }

    //------  Display One Professional----
    public Professional findOne(String userName){
        Assert.notNull(userName, "The entity must not be null!");
       return  homifyProfessionalRepository.findOne(Professional.class,userName);
    }

    //------  All Professional for given period----
    public Iterable<Professional> findAll(String fromDate, String toDate){
        return homifyProfessionalRepository.findAllByGivenPeriod(fromDate,toDate);
    }

    //------  All Professional by latitude & longitude----
    public Iterable<Professional> findAllByLatitudeLongitude(String latitude, String longitude){
        return homifyProfessionalRepository.findAllByLatitudeLongitude(latitude,longitude);
    }

    //------  All Professional by type----
    public Iterable<Professional> findAllByType(String type){
        return homifyProfessionalRepository.findAllByType(type);
    }

    //--check if userName exists--
    public boolean exists(java.lang.String userName){
        Assert.notNull(userName, "The entity does not exist!");
        return (this.entityManager.contains(userName) ? true : false);
    }

}
