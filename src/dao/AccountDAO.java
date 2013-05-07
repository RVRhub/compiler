package dao;

import entity.GenericAccountInfo;

import java.sql.SQLException;
import java.util.Collection;

public interface AccountDAO {

    public Collection getAccount() ;

    public void insertUser(GenericAccountInfo users);

    public boolean deleteUser(GenericAccountInfo users);

    public void updateGenericAccountInfo(GenericAccountInfo users);

    public void updateFullAccountInfo (GenericAccountInfo users);

}
