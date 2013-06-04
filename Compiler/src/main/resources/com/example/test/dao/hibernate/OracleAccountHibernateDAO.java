package com.example.test.dao.hibernate;

import com.example.test.dao.AccountDAO;
import com.example.test.entity.GenericAccountInfo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        List<GenericAccountInfo> accountsInfo = new ArrayList<GenericAccountInfo>();
        try {
            tx = session.beginTransaction();
            accountsInfo = session.createCriteria(GenericAccountInfo.class).list();
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
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(users);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public boolean deleteUser(GenericAccountInfo users) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(users);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public GenericAccountInfo getUserById(Long id) {
        Session session = factory.openSession();
        Transaction tx = null;
        GenericAccountInfo accountsInfo = null;
        try {
            tx = session.beginTransaction();
            accountsInfo = (GenericAccountInfo) session.load(GenericAccountInfo.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void updateGenericAccountInfo(GenericAccountInfo users) {
        Session session = factory.openSession();
        Transaction tx = null;
        GenericAccountInfo accountsInfo = null;
        try {
            tx = session.beginTransaction();
            session.update(users);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
