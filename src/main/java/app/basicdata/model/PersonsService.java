/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.basicdata.model;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonsService {
    
    private final Logger logger = LoggerFactory.getLogger(PersonsService.class);
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public List<Person> findByPid(String pid) {
        List<Person> entries = new ArrayList<>();
        jdbcTemplate.query("SELECT * FROM persons where pid=? LIMIT 1", new Object[]{pid}, (rs, row) -> new Person(rs.getString("cardid"), rs.getString("pname"), rs.getString("pid"), rs.getString("dob"), rs.getString("sex"), rs.getString("issue"), rs.getBoolean("enable"))).forEach(user -> entries.add(user));
        return entries;
    }

//        public List<Person> findByCardInfo(Person person) {
//        List <Person> entries = new ArrayList<>();
//        jdbcTemplate.query("SELECT * FROM persons where pid=? LIMIT 1", new Object[]{person}, (rs, row) -> new Person(rs.getString("cardid"),rs.getString("pname"),rs.getString("pid"), rs.getString("dob"), rs.getString("sex"), rs.getString("issue"),rs.getBoolean("enable"))).forEach(user-> entries.add(user));
//        return entries;
//    }
    public Person updatePerson(Person person) {
        person.setEnable(true);
        jdbcTemplate.update("INSERT INTO persons(cardid, pname, pid, dob, sex, issue, enable) VALUES(?,?,?,?,?,?,?)", person.getCardid(), person.getPname(), person.getPid(), person.getDob(), person.getSex(), person.getIssue(), person.isEnable());

//                 String updateSQL = "INSERT INTO " + TABLENAME + " (FullName, PersonGuid, SchoolID, subject, classroom, Creator) "
//                + "VALUES (?,?,?,?,?,?) "
//                + "ON DUPLICATE KEY UPDATE FullName = VALUES(FullName), SchoolID = VALUES(SchoolID), subject = VALUES(subject), classroom = VALUES(classroom), Creator = VALUES(Creator) ";
        return person;
    }
    
    public boolean updatePersonInfo(String pid, PersonInfo personinfo) {
        logger.info(String.format("update person info:%s,%s,%s", pid,personinfo.getSchoolid(),personinfo.getTitle()));
        jdbcTemplate.update("INSERT INTO personsInfo(pid,schoolid,title) VALUES(?,?,?)",pid, personinfo.getSchoolid(),personinfo.getTitle());
        return true;
    }
    
    public void disablePerson(String pid){
        jdbcTemplate.update("UPDATE persons SET enable=0 where pid=?",new Object[]{pid});
    }
    
    public int countPersonInfo(String pid){
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM personsInfo where pid=?",new Object[]{pid}, Integer.class);
    }
    public void deletePersonInfo(String pid){
        jdbcTemplate.update("DELETE FROM personsInfo where pid=?", pid);
    }
    public List<PersonInfo> findPersonInfoByPid(String pid){
        List<PersonInfo> entries = new ArrayList<>();
         jdbcTemplate.query("SELECT * FROM personsInfo where pid=?", new Object[]{pid}, (rs, row) -> new PersonInfo(rs.getString("schoolid"), rs.getString("title"))).forEach(personinfo -> entries.add(personinfo));
      return entries;
    }
    
}
