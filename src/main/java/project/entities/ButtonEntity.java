package project.entities;


import javax.persistence.*;

/**
 * Сущность блока кнопок
 */
@Entity
@Table(name = "buttons")
public class ButtonEntity {

    //номер блока кнопок
    @Column(name = "number")
    private int number;

    //номер поста
    @Column(name = "post")
    private int post;

    //сторона
    @Column(name = "side")
    private Boolean side;

    //идентификатор
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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
     * Возвращает номер поста
     * @return
     * номер поста
     */
    public int getPost() {
        return post;
    }

    /**
     * Устанавливает номер поста
     * @param post
     * номер поста
     */
    public void setPost(int post) {
        this.post = post;
    }

    /**
     * Возвращает сторону
     * @return
     * сторона
     */
    public Boolean getSide() {
        return side;
    }

    /**
     * Устанавливает сторону
     * @param side
     * сторона
     */
    public void setSide(Boolean side) {
        this.side = side;
    }

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
}
