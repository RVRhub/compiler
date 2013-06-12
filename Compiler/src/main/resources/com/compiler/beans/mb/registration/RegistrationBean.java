package com.compiler.beans.mb.registration;


import com.compiler.beans.mb.login.LoginBean;
import com.compiler.dao.hibernate.OracleAccountHibernateDAO;
import com.compiler.entity.GenericAccountInfo;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;

@ManagedBean(name = "RegistrationBean")
@SessionScoped
public class RegistrationBean {
    private static Logger log = Logger.getLogger(LoginBean.class);


    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String wplace;
    private Date dob;
    private String city;
    private String state;
    private String country;

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getWplace() {
        return wplace;
    }

    public void setWplace(String wplace) {
        this.wplace = wplace;
    }

    public void register() {
        log.info("[reg] start");
        GenericAccountInfo acc = new GenericAccountInfo();

        acc.setFname(firstname);
        acc.setLname(lastname);
        acc.setEmail(email);
        acc.setPass(password);
        acc.setBirth(dob);
        acc.setWorkplace(wplace);
        acc.setCity(city);
        acc.setState(state);
        acc.setCountry(country);

        new OracleAccountHibernateDAO().insertUser(acc);
        log.info("[reg] finish");
    }



}