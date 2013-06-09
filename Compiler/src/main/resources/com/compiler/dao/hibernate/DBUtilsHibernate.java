package com.compiler.dao.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javax.ejb.Stateless;
import java.util.Locale;

public class DBUtilsHibernate {
    private static Logger log = Logger.getLogger(DBUtilsHibernate.class);

    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;
    /**
     * Initialization of data source.
     */
    static {
        Locale.setDefault(Locale.ENGLISH);
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).buildServiceRegistry();
        log.info("[Hibernate] Start hibernate - success.");
        factory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getConnection() {
        return factory;
    }
}
