package model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Person {
    private Long id;
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
