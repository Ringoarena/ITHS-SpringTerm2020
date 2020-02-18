package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonDAOImp implements PersonDAO{
    @PersistenceContext(unitName = "Rest1PU")
    EntityManager em;

    @Override
    public void add(Person person) {
        System.out.println("adding " + person.getName());
        em.persist(person);
    }

    @Override
    public List<Person> getAll() {
        return em.createQuery("FROM Person AS p", Person.class).getResultList();
    }
}
