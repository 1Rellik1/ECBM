package project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Сущность типов происшествий
 */
@Entity
@Table(name = "accidentclasses")
public class AccidentClasses {
    //идентификатор
    @Id
    @Column(name = "id")
    private int id;
    //номер типа происшествия
    @Column(name = "number")
    private int number;
    //название типа происшествия
    @Column(name = "name")
    private String name;

    /**
     * Возвращает идентификатор
     * @return
     * идентификатор
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает номер типа происшествия
     * @return
     * номер типа происшествия
     */
    public int getNumber() {
        return number;
    }

    /**
     * Возвращает название типа происшествия
     * @return
     * название типа происшествия
     */
    public String getName() {
        return name;
    }
}
