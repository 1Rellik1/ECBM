package croc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "buttonevents")
public class ButtonEvents {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "btype")
    private int btype;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "number")
    private int number;

    @Column(name = "counter1")
    private int Counter1;

    @Column(name = "counter2")
    private int Counter2;

    @Column(name = "counter3")
    private int Counter3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBtype() {
        return btype;
    }

    public void setBtype(int btype) {
        this.btype = btype;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCounter1() {
        return Counter1;
    }

    public void setCounter1(int counter1) {
        Counter1 = counter1;
    }

    public int getCounter2() {
        return Counter2;
    }

    public void setCounter2(int counter2) {
        Counter2 = counter2;
    }

    public int getCounter3() {
        return Counter3;
    }

    public void setCounter3(int counter3) {
        Counter3 = counter3;
    }
}
