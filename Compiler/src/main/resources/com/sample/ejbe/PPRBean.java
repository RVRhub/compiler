package com.sample.ejbe;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean(name="pprBean")
public class PPRBean implements Serializable {

    private String firstname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}