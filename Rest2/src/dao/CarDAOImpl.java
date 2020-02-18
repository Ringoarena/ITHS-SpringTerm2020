package dao;

import model.Car;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CarDAOImpl implements CarDAO {
    @PersistenceContext(unitName = "rest2pu")
    EntityManager em;

    @Override
    public void create(Car car) {
        em.persist(car);
    }

    @Override
    public Car get(Long id) {
        return em.find(Car.class, id);
    }

    @Override
    public List<Car> getAll() {
        return em.createQuery("FROM Car AS c", Car.class).getResultList();
    }

    @Override
    public void updateCar(Car car) {
        em.merge(car);
    }

    @Override
    public void delete(Long id) {
        em.remove(em.find(Car.class, id));
    }
}
