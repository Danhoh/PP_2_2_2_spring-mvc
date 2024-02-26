import Entity.Car;
import dao.CarDao;
import util.HibernateUtil;

public class Main {
    public static void main(String[] args) { // просто добавляю машины в дб
        CarDao carDao = new CarDao();
        carDao.deleteAllCars();
        Car[] cars = {
                new Car("BMW", "X5", 1234),
                new Car("BMW", "X6", 1488),
                new Car("BMW", "X7", 1337),
                new Car("Lada", "Calina", 228),
                new Car("Lada", "Granta", 3204),
                new Car("Gaz", "21010", 2233),
        };
        carDao.saveAll(cars);
        HibernateUtil.shutdown();
    }
}
