package project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 *  Сущность состояния кнопки
 */
@Entity
@Table(name = "buttonevents")
public class ButtonEvents {

    //Идентификатор
    @Id
    @Column(name = "id")
    private int id;

    //состояние блока кнопок
    @Column(name = "btype")
    private int btype;

    //Время фиксации состояния
    @Column(name = "timestamp")
    private Timestamp timestamp;

    //номер блока кнопок
    @Column(name = "number")
    private int number;

    //кол-во нажатий на 1 кнопку
    @Column(name = "counter1")
    private int Counter1;

    //кол-во нажатий на 2 кнопку
    @Column(name = "counter2")
    private int Counter2;

    //кол-во нажатий на 3 кнопку
    @Column(name = "counter3")
    private int Counter3;

    /**
     * Возвращает идентификатор
     * @return
     * идентификатор пользователя
     */
    public int getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор
     * @param id
     * идентификатор пользователя
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Возвращает состояние блока кнопок
     * @return
     * состояние блока кнопок
     */
    public int getBtype() {
        return btype;
    }

    /**
     * Устанавливает состояние блока кнопок
     * @param btype
     * состояние блока кнопок
     */
    public void setBtype(int btype) {
        this.btype = btype;
    }

    /**
     * Возвращает время фиксации состояния
     * @return
     * время фиксации состояния
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * Устанавливает время фиксации состояния
     * @param timestamp
     * время фиксации состояния
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Возвращает номер блока кнопок
     * @return
     * номер блока кнопок
     */
    public int getNumber() {
        return number;
    }

    /**
     * Устанавливает номер блока кнопок
     * @param number
     * номер блока кнопок
     */
    public void setNumber(int number) {
        this.number = number;
    }


    /**
     * Возвращает кол-во нажатий на 1 кнопку
     * @return
     * кол-во нажатий на 1 кнопку
     */
    public int getCounter1() {
        return Counter1;
    }

    /**
     * Устанавливает кол-во нажатий на 1 кнопку
     * @param counter1
     * кол-во нажатий на 1 кнопку
     */
    public void setCounter1(int counter1) {
        Counter1 = counter1;
    }

    /**
     * Возвращает кол-во нажатий на 2 кнопку
     * @return
     * кол-во нажатий на 2 кнопку
     */
    public int getCounter2() {
        return Counter2;
    }

    /**
     * Устанавливает кол-во нажатий на 2 кнопку
     * @param counter2
     * кол-во нажатий на 2 кнопку
     */
    public void setCounter2(int counter2) {
        Counter2 = counter2;
    }

    /**
     * Возвращает кол-во нажатий на 3 кнопку
     * @return
     * кол-во нажатий на 3 кнопку
     */
    public int getCounter3() {
        return Counter3;
    }

    /**
     * Устанавливает кол-во нажатий на 3 кнопку
     * @param counter3
     * кол-во нажатий на 3 кнопку
     */
    public void setCounter3(int counter3) {
        Counter3 = counter3;
    }
}
