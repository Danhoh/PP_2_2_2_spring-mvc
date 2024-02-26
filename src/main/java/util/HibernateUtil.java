package util;

import Entity.Car;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private HibernateUtil() {
    }

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/pp222");
            configuration.setProperty("hibernate.connection.username", "postgres");
            configuration.setProperty("hibernate.connection.password", "1234567890");
            configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
            configuration.setProperty("hibernate.connection.show_sql", "true");
            configuration.setProperty("hibernate.connection.format_sql", "true");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");

            configuration.addAnnotatedClass(Car.class);

            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Закрытие фабрики сеансов при завершении приложения
        getSessionFactory().close();
    }
}
