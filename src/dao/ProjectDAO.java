package dao;
import entity.GenericAccountInfo;
import entity.GenericProjectInfo;

import java.sql.SQLException;
import java.util.Collection;

public interface ProjectDAO {

    public Collection getProject();

    public void insertProject(GenericProjectInfo projects);

    public void deleteProject(GenericProjectInfo projects);

    public void updateGenericProjectInfo(GenericProjectInfo projects);

    public void updateProjectDetails (GenericProjectInfo projects);

}
