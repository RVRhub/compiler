package com.example.test.dao.hibernate;


import com.example.test.dao.ProjectDAO;
import com.example.test.entity.GenericAccountInfo;
import com.example.test.entity.GenericProjectInfo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OracleProjectHibernateDAO implements ProjectDAO {
    private static SessionFactory factory;

    public OracleProjectHibernateDAO()
    {
        this.factory = DBUtilsHibernate.getConnection();
    }

    @Override
    public Collection<GenericProjectInfo> getProject() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<GenericProjectInfo> projectInfo = new ArrayList<GenericProjectInfo>();
        try {
            tx = session.beginTransaction();
            projectInfo = session.createCriteria(GenericProjectInfo.class).list();
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
    public void insertProject(GenericProjectInfo projects) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(projects);
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
    public void deleteProject(GenericProjectInfo projects) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(projects);
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
    public void updateGenericProjectInfo(GenericProjectInfo projects) {
        Session session = factory.openSession();
        Transaction tx = null;
        GenericAccountInfo projectsInfo = null;
        try {
            tx = session.beginTransaction();
            session.update(projects);
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
