package com.compiler.dao;

import java.util.Collection;

import com.compiler.entity.GenericProjectInfo;

public interface ProjectDAO {

    public Collection<GenericProjectInfo> getProject();

    public void insertProject(GenericProjectInfo projects);

    public void deleteProject(GenericProjectInfo projects);

    public void updateGenericProjectInfo(GenericProjectInfo projects);


}
