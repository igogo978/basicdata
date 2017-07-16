/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.basicdata.model;

public class PersonInfo {

    private String schoolid;
    private String title;

    public PersonInfo(String schoolid, String title) {
        this.schoolid = schoolid;
        this.title = title;
    }

    public String getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(String schoolid) {
        this.schoolid = schoolid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PersonInfo() {
    }

}
