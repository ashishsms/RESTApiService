package com.homify.homify.server.HomifyController;

import com.homify.homify.business.Professional;
import com.homify.homify.server.reference.Professional.ProfessionalJDO;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/professional")
public class HomifyProfessionalManager {


    @Autowired
    private ProfessionalJDO professionalRef;

    public HomifyProfessionalManager() {
    }

    //---- Create Professional ----
    @PostMapping(consumes = "application/json")
    public void createProfessional(@RequestBody Professional professional) {
        professionalRef.createProfessional(professional);
    }

    //---- Delete Professional ----
    @DeleteMapping(path = "/{username}")
    public void delete(@PathVariable("username") String username) {
        professionalRef.deleteByUserName(username);
    }

    //---- Update Professional ----
    @PutMapping(path = "/{username}")
    public Professional update(@PathVariable("username") String username, @RequestBody Professional professional) throws BadHttpRequest {
        return professionalRef.update(username,professional);
    }

    //------  All Professional for given period----
    @GetMapping(path = "/{fromDate},{toDate}")
    public Iterable<Professional> findAll(@PathVariable("fromDate") String fromDate,@PathVariable("toDate") String toDate) {
        return professionalRef.findAll(fromDate,toDate);
    }

    //------  Display One Professional----
    @GetMapping(path = "/{username}")
    public Professional find(@PathVariable("username") String username) {
        return professionalRef.findOne(username);
    }

    //------  All Professional by latitude & longitude----
    @GetMapping(path = "/{latitude},{longitude}")
    public Iterable<Professional> findAllByLatitudeLongitude(@PathVariable("latitude") String latitude,@PathVariable("longitude") String longitude) {
        return professionalRef.findAllByLatitudeLongitude(latitude,longitude);
    }

    //------  All Professional by type----
    @GetMapping(path = "/{type}")
    public Iterable<Professional> findAllByType(@PathVariable("type") String type) {
        return professionalRef.findAllByType(type);
    }


}
