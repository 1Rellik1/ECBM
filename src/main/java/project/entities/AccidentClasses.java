package croc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accidentclasses")
public class AccidentClasses {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "number")
    private int number;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
