package model;

import java.util.List;

public interface PersonDAO {
    void add(Person person);
    List<Person> getAll();
}
