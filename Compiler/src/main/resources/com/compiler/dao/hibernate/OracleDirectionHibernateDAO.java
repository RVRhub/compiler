package com.compiler.dao.hibernate;

import com.compiler.dao.DirectionDAO;
import com.compiler.entity.Direction;
import com.compiler.entity.GenericAccountInfo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OracleDirectionHibernateDAO implements DirectionDAO {
    private static SessionFactory factory;

    public OracleDirectionHibernateDAO()
    {
        this.factory = DBUtilsHibernate.getConnection();
    }


    @Override
    public Collection<Direction> getDirection() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Direction> dir = new ArrayList<Direction>();
        try {
            tx = session.beginTransaction();
            dir = session.createCriteria(Direction.class).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return dir;
    }

    @Override
    public void insertDir(Direction dir) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(dir);
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
    public boolean deleteDir(Direction dir) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(dir);
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
    public void updateDir(Direction dir) {
        Session session = factory.openSession();
        Transaction tx = null;
        GenericAccountInfo accountsInfo = null;
        try {
            tx = session.beginTransaction();
            session.update(dir);
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
