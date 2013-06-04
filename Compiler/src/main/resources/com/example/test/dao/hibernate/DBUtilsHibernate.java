package com.example.test.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

<<<<<<< HEAD
import java.util.Locale;


=======

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: Roman
 * Date: 29.05.13
 * Time: 0:57
 * To change this template use File | Settings | File Templates.
 */
>>>>>>> 3f450e23d87742140533f1abbea551f835a8e9af
public class DBUtilsHibernate {
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
             System.out.println("Start hibernate");
            factory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getConnection() {
        return factory;
    }
}
