package model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class PersonList {
    private List<Person> persons;

    public PersonList(List<Person> persons) {
        this.persons = persons;
    }

    public PersonList() {
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
