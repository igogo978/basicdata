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

    private int carid;
    private String pname;  //中文名字
    private String pid; //身份證字號
    private int dob; //出生年月日
    private String sex;  //姓別
    private int issue;
    private String schoolid;
    private String title;

//    private Map<String, String> schoolidObj = new HashMap<>();
    private ArrayList<HashMap<String, String>> schoolids = new ArrayList<>();

    public ArrayList<HashMap<String, String>> getSchoolids() {
        return schoolids;
    }

    public void setSchoolids(ArrayList<HashMap<String, String>> schoolids) {
        this.schoolids = schoolids;
    }
    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    public Person() {
    }

//    public Person(int carid, String pname, String pid, int dob, String sex, int issue) {
//        this.carid = carid;
//        this.pname = pname;
//        this.pid = pid;
//        this.dob = dob;
//        this.sex = sex;
//        this.issue = issue;
//    }

 

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
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

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
}
