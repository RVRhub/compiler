package com.example.test.dao.hibernate;

import com.example.test.dao.AccountDAO;
<<<<<<< HEAD
=======
import com.example.test.entity.Direction;
>>>>>>> 3f450e23d87742140533f1abbea551f835a8e9af
import com.example.test.entity.GenericAccountInfo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

=======
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
>>>>>>> 3f450e23d87742140533f1abbea551f835a8e9af
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
<<<<<<< HEAD
        List<GenericAccountInfo> accountsInfo = new ArrayList<GenericAccountInfo>();
        try {
            tx = session.beginTransaction();
            accountsInfo = session.createCriteria(GenericAccountInfo.class).list();
=======
        List<GenericAccountInfo> accountsInfo = null;
        try {
            tx = session.beginTransaction();
            accountsInfo = session.createQuery("FROM GenericAccountInfo").list();
>>>>>>> 3f450e23d87742140533f1abbea551f835a8e9af
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
<<<<<<< HEAD
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
=======
        //To change body of implemented methods use File | Settings | File Templates.
>>>>>>> 3f450e23d87742140533f1abbea551f835a8e9af
    }

    @Override
    public boolean deleteUser(GenericAccountInfo users) {
<<<<<<< HEAD
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
=======
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public GenericAccountInfo getUserById(int user_id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
>>>>>>> 3f450e23d87742140533f1abbea551f835a8e9af
    }

    @Override
    public void updateGenericAccountInfo(GenericAccountInfo users) {
<<<<<<< HEAD
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
=======
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateFullAccountInfo(GenericAccountInfo users) {
        //To change body of implemented methods use File | Settings | File Templates.
>>>>>>> 3f450e23d87742140533f1abbea551f835a8e9af
    }
}
