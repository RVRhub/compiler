package com.example.test.dao;

import java.util.Collection;

import com.example.test.entity.GenericAccountInfo;

public interface AccountDAO {

    public Collection<GenericAccountInfo> getAccount() ;

    public void insertUser(GenericAccountInfo users);

    public boolean deleteUser(GenericAccountInfo users);

    public GenericAccountInfo getUserById(Long id);

    public void updateGenericAccountInfo(GenericAccountInfo users);

}

