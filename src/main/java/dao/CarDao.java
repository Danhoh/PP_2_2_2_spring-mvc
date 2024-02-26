package dao;

import Entity.Car;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
    public void save(Car car) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveAll(Car[] cars) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            for (Car car : cars) {
                session.save(car);
            }
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Car> getAllCars() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Car", Car.class).list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }

    public void deleteAllCars() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("DELETE Car").executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Car> getNCars(Integer count) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            TypedQuery<Car> query = session.createQuery("FROM Car", Car.class);
            query.setMaxResults(count);
            return query.getResultList();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }
}
