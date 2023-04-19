import daos.CarDAO;
import models.CarDTO;

public class App {
    public static void main(String[] args) {
        CarDAO carDAO = new CarDAO();

        // get car by id
        System.out.println("Get car by id:");
        System.out.println(carDAO.findById(1).toString());

        // get all cars from DB
        System.out.println("\nGet all cars:");
        carDAO.findAll().forEach(car -> {
            System.out.println(car.toString());
        });

        // update car
        System.out.println("\nupdate a car:");
        CarDTO car = carDAO.findAll().get(0);
        System.out.println(car);
        System.out.println("change to");
        car.setColor("NEW COLOR");
        System.out.println(carDAO.update(car));
        System.out.println("change back to");
        car.setColor("BLACK");
        System.out.println(carDAO.update(car));

        // add car into DB
        CarDTO car2 = new CarDTO(11, "Toyota", "RAV4", 2021, "PINK", "HFKWU29EIS82NC027");
        carDAO.create(car2);
        System.out.println("\nAfter added car with id=11");
        carDAO.findAll().forEach(c -> {
            System.out.println(c.toString());
        });

        // delete car into DB
        carDAO.delete(11);
        System.out.println("\nAfter delete car with id=11");
        carDAO.findAll().forEach(c -> {
            System.out.println(c.toString());
        });
    }
}
