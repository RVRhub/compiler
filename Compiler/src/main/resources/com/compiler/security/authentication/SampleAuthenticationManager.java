package com.compiler.security.authentication;

import com.compiler.dao.hibernate.OracleAccountHibernateDAO;
import com.compiler.entity.GenericAccountInfo;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * User: Roman
 * Date: 08.06.13
 */
public class SampleAuthenticationManager implements AuthenticationManager {
    private static Logger log = Logger.getLogger(SampleAuthenticationManager.class);

    //TODO for MD5
    private Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();

    public Authentication authenticate(Authentication auth) throws AuthenticationException {

        log.info("[authenticate] start");

        GenericAccountInfo user = new OracleAccountHibernateDAO().getUser(auth.getName());

        log.info("[authenticate] user: " + user);

        if(user == null)
            throw new BadCredentialsException("User does not exists");

        if(!user.getPass().equals(auth.getCredentials()))
            throw new BadCredentialsException("Wrong password!");

        log.info("[authenticate] user success: " + user);

        return new UsernamePasswordAuthenticationToken(
                auth.getName(),
                auth.getCredentials(),
                getAuthorities(0));
    }

    public Collection<GrantedAuthority> getAuthorities(Integer access) {

        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

        authList.add(new GrantedAuthorityImpl("ROLE_USER"));

        if ( access.compareTo(1) == 0) {
            authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
        }

        return authList;
    }
}
