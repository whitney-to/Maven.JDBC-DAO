package daos;

import java.util.List;

import models.CarDTO;

public interface ICarDAO {
    public CarDTO findById(int id);

    public List<CarDTO> findAll();

    public CarDTO update(CarDTO dto);

    public CarDTO create(CarDTO dto);

    public void delete(int id);
}
