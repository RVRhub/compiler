package com.example.test.entity;

import java.util.Date;


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

    public GenericAccountInfo()  {
//        setUser_id(rs.getInt(1));
//        setFname(rs.getString(2));
//        setLname(rs.getString(3));
//        setEmail(rs.getString(4));
//        setPass(rs.getString(5));
//        setBirth(rs.getDate(6));
//        setWorkplace(rs.getString(7));
//        setCity(rs.getString(8));
//        setState(rs.getString(9));
//        setCountry(rs.getString(10));
//        setKnowproglang(rs.getString(11));
//    	  (ResultSet rs)
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

    @Override
    public String toString() {
        return "com.example.test.entity.GenericAccountInfo{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", birth=" + birth +
                ", workplace='" + workplace + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", knowproglang='" + knowproglang + '\'' +
                '}';
    }



}
