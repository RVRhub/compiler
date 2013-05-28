package com.example.test.dao.hibernate;

import com.example.test.dao.AccountDAO;
import com.example.test.entity.Direction;
import com.example.test.entity.GenericAccountInfo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Roman
 * Date: 29.05.13
 * Time: 0:52
 * To change this template use File | Settings | File Templates.
 */
public class OracleAccountHibernateDAO implements AccountDAO {
    private static SessionFactory factory;

    public OracleAccountHibernateDAO()
    {
        this.factory = DBUtilsHibernate.getConnection();
    }

    @Override
    public Collection<GenericAccountInfo> getAccount() {

        Session session = factory.openSession();
        Transaction tx = null;
        List<GenericAccountInfo> accountsInfo = null;
        try {
            tx = session.beginTransaction();
            accountsInfo = session.createQuery("FROM GenericAccountInfo").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return accountsInfo;
    }

    @Override
    public void insertUser(GenericAccountInfo users) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean deleteUser(GenericAccountInfo users) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public GenericAccountInfo getUserById(int user_id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateGenericAccountInfo(GenericAccountInfo users) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateFullAccountInfo(GenericAccountInfo users) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
