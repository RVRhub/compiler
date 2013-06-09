package com.compiler.beans.mb.account;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.bean.ManagedBean;

/**
 * User: Roman
 * Date: 09.06.13
 */

@ManagedBean(name="startAccount")
public class StartAccount {

    public String getUsername() {
        return userAuth();
    }

    private String userAuth()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            return authentication.getName();
        }
        return null;
    }

}
