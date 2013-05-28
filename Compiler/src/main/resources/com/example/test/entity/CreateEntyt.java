package com.example.test.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: Roman
 * Date: 29.05.13
 * Time: 2:25
 * Class for create table
 */
public class CreateEntyt {
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public static void main(String[] args) {
        try {

            Locale.setDefault(Locale.ENGLISH);

            Configuration configuration = new Configuration();
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).buildServiceRegistry();

            factory = configuration.buildSessionFactory(serviceRegistry);

            System.out.println("Create succsee");

        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }
}
