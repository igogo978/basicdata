/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.basicdata.api;

import app.basicdata.model.Person;
import app.basicdata.model.PersonInfo;
import app.basicdata.model.PersonsService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{cardid}")
public class UserInfoController {

    private final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    PersonsService service;

    @RequestMapping(value = "/personinfo", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Person updateUser(@PathVariable String cardid, @RequestBody Person cardinfoPerson) {
        List<Person> persons;
        persons = service.findByPid(cardinfoPerson.getPid());
        logger.info("persons size:" + persons.size());
        logger.info(String.format("size:%d", persons.size()));
        //找到帳號檢查卡片資料是否完全符合, 無資料則新增到資料庫
        if (persons.size() > 0) {
            if (isCardInfoMatch(persons.get(0), cardinfoPerson)) {
                //update person info
                updatePersonInfoDB(cardinfoPerson);
                cardinfoPerson.setErr("更新成功");

                logger.info("all match");
            } else {
                //卡片資訊不一樣, 退回, 資料狀態disable
                service.disablePerson(cardinfoPerson.getPid());
                logger.info("not match");
                cardinfoPerson.setErr(String.format("卡片資訊不符合,與卡片號碼%s身份証號碼重覆,為確保安全已將此身份證號碼鎖定,請聯絡客服人員", persons.get(0).getCardid()));
            }

        } else {
            //update db
            service.updatePerson(cardinfoPerson);

            updatePersonInfoDB(cardinfoPerson);
            cardinfoPerson.setErr("更新成功");
//            service.updatePerson(cardinfoPerson);
//            cardinfoPerson.getPersoninfo().forEach((personinfo) -> {
//                if (service.countPersonInfo(cardinfoPerson.getPid()) != 0) {
//                    service.deletePersonInfo(cardinfoPerson.getPid());
//                }
//                service.updatePersonInfo(cardinfoPerson.getPid(), personinfo);
//            });
        }

        return cardinfoPerson;
    }

    @RequestMapping(value = "/personinfo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PersonInfo> getPersonInfo(@PathVariable String cardid, @RequestBody Person cardinfoPerson) {
        List<Person> persons;
        persons = service.findByPid(cardinfoPerson.getPid());
        List<PersonInfo> entries;
        if (persons.size() > 0) {
            if (isCardInfoMatch(persons.get(0), cardinfoPerson)) {

                entries = service.findPersonInfoByPid(cardinfoPerson.getPid());
                return entries;
            }
        }

        return null;
    }

    private boolean isCardInfoMatch(Person dbPerson, Person cardPerson) {
        return dbPerson.getCardid().equals(cardPerson.getCardid())
                && dbPerson.getPname().equals(cardPerson.getPname())
                && dbPerson.getDob().equals(cardPerson.getDob())
                && dbPerson.getSex().equals(cardPerson.getSex())
                && dbPerson.getIssue().equals(cardPerson.getIssue());

    }

    private void updatePersonInfoDB(Person cardinfoPerson) {
        //每次皆清空該使用者資料, 以最新一次資料整批更新,
        if (service.countPersonInfo(cardinfoPerson.getPid()) != 0) {
            service.deletePersonInfo(cardinfoPerson.getPid());
        }
        cardinfoPerson.getPersoninfo().forEach((personinfo) -> {
            service.updatePersonInfo(cardinfoPerson.getPid(), personinfo);
        });
    }

}
