package com.example.test.dao;

import java.util.Collection;

import com.example.test.entity.GenericProjectInfo;

public interface ProjectDAO {

    public Collection<GenericProjectInfo> getProject();

    public void insertProject(GenericProjectInfo projects);

    public void deleteProject(GenericProjectInfo projects);

    public void updateGenericProjectInfo(GenericProjectInfo projects);

    public void updateProjectDetails (GenericProjectInfo projects);

}
