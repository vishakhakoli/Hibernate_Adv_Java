package com.adv.java.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.adv.java.hibernate.Address;
import com.adv.java.hibernate.entities.Student;  

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();

            configuration.setProperty("hibernate.connection.driver_class", "oracle.jdbc.OracleDriver");
            configuration.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@//10.165.187.28:1532/orcl12c");
            configuration.setProperty("hibernate.connection.username", "CRS_GOLD");
            configuration.setProperty("hibernate.connection.password", "CRS_GOLD");

            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
            configuration.setProperty("hibernate.hbm2ddl.auto", "create");
            configuration.setProperty("hibernate.show_sql", "true");

            configuration.addAnnotatedClass(Student.class);  
            configuration.addAnnotatedClass(Address.class);  

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

