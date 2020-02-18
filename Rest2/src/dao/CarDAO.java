package dao;

import model.Car;

import java.util.List;

public interface CarDAO {
    void create(Car car);
    Car get(Long id);
    List<Car> getAll();
    void updateCar(Car car);
    void delete(Long id);
}
