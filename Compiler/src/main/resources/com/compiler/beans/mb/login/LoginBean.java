package com.compiler.beans.mb.login;

/**
 * User: Roman
 * Date: 09.06.13
 */
import com.compiler.security.authentication.SampleAuthenticationManager;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.context.FacesContext;
import javax.faces.application.*;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Serializable;

@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean implements Serializable {

    private static Logger log = Logger.getLogger(LoginBean.class);

    private static AuthenticationManager authenticationManager = new SampleAuthenticationManager();

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login(ActionEvent actionEvent) {
        log.info("[login] start");
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean loggedIn = false;

        if(username != null && password != null) {
            log.info("[login] username" + username);
            loggedIn = authenticationAction();
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
        } else {
            log.info("[login] Not username!!!");
            loggedIn = authenticationAction();
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);

        log.info("[login] finish");

      //  return true;
    }

    public String forward()
    {

        return true ? "/pages/secure/account.xhtml" :"";
    }

    private Boolean authenticationAction()
    {
        Authentication request = new UsernamePasswordAuthenticationToken(username, password);
        Authentication result = authenticationManager.authenticate(request);
        SecurityContextHolder.getContext().setAuthentication(result);

        return  result.isAuthenticated();
    }


}
