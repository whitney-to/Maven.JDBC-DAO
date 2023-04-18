import daos.CarDAO;

public class App {
    public static final String URL = "jdbc:mysql://localhost:3306/testdb";
    public static final String USER = "testuser";
    public static final String PASS = "testpass";

    public static void main(String[] args) {
        CarDAO carDAO = new CarDAO();
        // System.out.println(carDAO.findById(1).toString());
        carDAO.findAll().forEach(car -> {
            System.out.println(car.toString());
        });

    }
}
