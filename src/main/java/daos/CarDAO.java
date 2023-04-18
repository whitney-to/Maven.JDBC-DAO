package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import models.CarDTO;

public class CarDAO implements ICarDAO {
    Connection connection = ConnectionFactory.getConnection();

    @Override
    public CarDTO findById(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM cars WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return extractCarFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CarDTO> findAll() {

        return null;
    }

    @Override
    public CarDTO update(CarDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public CarDTO create(CarDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private CarDTO extractCarFromResultSet(ResultSet rs) throws SQLException {
        CarDTO car = new CarDTO();

        car.setId(rs.getInt("id"));
        car.setMake(rs.getString("make"));
        car.setModel(rs.getString("model"));
        car.setYear(rs.getInt("year"));
        car.setColor(rs.getString("color"));
        car.setVin(rs.getString("vin"));

        return car;
    }
}
