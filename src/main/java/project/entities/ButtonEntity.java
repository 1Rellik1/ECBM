package croc.entities;


import javax.persistence.*;

@Entity
@Table(name = "buttons")
public class ButtonEntity {

    @Column(name = "number")
    private int number;


    @Column(name = "post")
    private int post;

    @Column(name = "side")
    private Boolean side;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public Boolean getSide() {
        return side;
    }

    public void setSide(Boolean side) {
        this.side = side;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
