package com.homify.homify.server.reference.Professional;

import com.homify.homify.business.Professional;
import javassist.tools.web.BadHttpRequest;

public interface ProfessionalJDO {

    public void createProfessional(Professional professional) ;

    public void deleteByUserName(String username);

    public Professional update(String username, Professional professional) throws BadHttpRequest;

 public com.homify.homify.business.Professional findOne(java.lang.String userName);

  public Iterable<Professional> findAll(String fromDate, String toDate);

    public Iterable<Professional> findAllByLatitudeLongitude(String latitude, String longitude);

    public Iterable<Professional> findAllByType(String type);
}
