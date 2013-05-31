package com.example.test.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "GenericProjectInfo")
public class GenericProjectInfo {


    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "project_id")
    private int project_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private GenericAccountInfo acc;

    @Column(name = "projname")
    private String projname;

    @Column(name = "proglang")
    private String proglang;

    @Column(name = "langplatform")
    private String langplatform;

    @Column(name = "projtype")
    private String projtype;

    @Column(name = "projcategory")
    private String projcategory;

    public GenericProjectInfo(){ }

    public GenericProjectInfo(int project_id, int user_id, String projname) {
        this.project_id = project_id;
        this.projname = projname;
    }

    public int getProject_id() {
        return project_id;
    }
    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProjname() {
        return projname;
    }
    public void setProjname(String projname) {
        this.projname = projname;
    }

    public String getProglang() {
        return proglang;
    }
    public void setProglang(String proglang) {
        this.proglang = proglang;
    }

    public String getLangplatform() {
        return langplatform;
    }
    public void setLangplatform(String langplatform) {
        this.langplatform = langplatform;
    }

    public String getProjtype() {
        return projtype;
    }
    public void setProjtype(String projtype) {
        this.projtype = projtype;
    }

    public String getProjcategory() {
        return projcategory;
    }
    public void setProjcategory(String projcategory) {
        this.projcategory = projcategory;
    }



    public String toString() {
        return project_id + "\t" + projname + "\t"
                + proglang + "\t" + langplatform + "\t" + projtype + "\t" + projcategory;
    }


//
//    public int getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(int user_id) {
//        this.user_id = user_id;
//    }
}
