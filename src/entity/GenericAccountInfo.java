package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Date;
import java.text.DateFormat;


public class GenericAccountInfo {

    private int user_id;
    private String fname;
    private String lname;
    private String email;
    private String pass;
    private Date birth;
    private String workplace;
    private String city;
    private String state;
    private String country;
    private String knowproglang;

    public GenericAccountInfo() {

    }


    public int getUser_id() {
        return user_id;
    }


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getKnowproglang() {
        return knowproglang;
    }

    public void setKnowproglang(String knowproglang) {
        this.knowproglang = knowproglang;
    }

    public String toString() {
        return user_id + "\t" + fname + "\t"
                + lname + "\t" + email + "\t" + pass + "\t" + DateFormat.getDateInstance(DateFormat.SHORT).format(birth) + "\t" + workplace + "\t" + city + "\t" + state
                + "\t" + country + "\t" + knowproglang;
    }
}
