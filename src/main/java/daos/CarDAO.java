package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM cars");
            ResultSet rs = ps.executeQuery();
            List<CarDTO> cars = new ArrayList<>();

            while (rs.next()) {
                CarDTO car = extractCarFromResultSet(rs);
                cars.add(car);
            }
            return cars;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public CarDTO update(CarDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public CarDTO create(CarDTO dto) {
        try {
            PreparedStatement ps = connection
                    .prepareStatement("insert into cars (id,make,model,year,color,vin) values(?,?,?,?,?,?)");
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getMake());
            ps.setString(3, dto.getModel());
            ps.setInt(4, dto.getYear());
            ps.setString(5, dto.getColor());
            ps.setString(6, dto.getVin());
            int i = ps.executeUpdate();
            if (i == 1) {
                return dto;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
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
