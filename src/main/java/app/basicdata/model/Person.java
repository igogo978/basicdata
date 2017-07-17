/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.basicdata.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author igogo
 */
public class Person {

    private String cardid;
    private String pname;  //中文名字
    private String pid; //身份證字號
    private String dob; //出生年月日
    private String sex;  //姓別
    private String issue; //發卡日期
    private String err; //error message

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
    
    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    //schoolid:title
    private ArrayList<PersonInfo> personinfo;

    public ArrayList<PersonInfo> getPersoninfo() {
        return personinfo;
    }

    public void setPersoninfo(ArrayList<PersonInfo> personinfo) {
        this.personinfo = personinfo;
    }

    public Person() {
    }

    public Person(String cardid, String pname, String pid, String dob, String sex, String issue, boolean enable) {
        this.cardid = cardid;
        this.pname = pname;
        this.pid = pid;
        this.dob = dob;
        this.sex = sex;
        this.issue = issue;
        this.enable = enable;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
