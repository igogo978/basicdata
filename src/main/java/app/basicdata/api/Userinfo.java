/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.basicdata.api;

import app.basicdata.BasicdataApplication;
import app.basicdata.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author igogo
 */
@RestController
@RequestMapping("/{cardid}/userinfo")
public class Userinfo {
       private final Logger logger = LoggerFactory.getLogger(Userinfo.class);

    
    @Autowired
    JdbcTemplate jdbcTemplate;
       
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Person updateUser(@PathVariable String cardid,@RequestBody Person person){
        logger.info(person.getPname());
        return person;
    }
    
}
