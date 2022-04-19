package project.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *  Сущность происшествий
 */
@Entity
@Table(name = "accidents")
public class Accidents {
    //идентификатор происшествия
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;
    //пост
    @Column(name = "post")
    private int post;
    //комментарий
    @Column(name = "description")
    private String description;
    //имя пользователя
    @Column(name = "username")
    private String username;
    //время фиксации
    @Column(name = "timestamp")
    private LocalDateTime timestamp;
    //тип происшествия
    @OneToOne
    @JoinColumn(name = "atype_id", referencedColumnName = "id")
    private AccidentClasses aTypeId;
    //Следующая версия происшествия
    @OneToOne
    @JoinColumn(name = "nextversion_id", referencedColumnName = "id")
    private Accidents NextVersionId;

    //время начала происшествия
    @Column(name = "start_time")
    private LocalDateTime startTime;

    //время конца происшествия
    @Column(name = "end_time")
    private LocalDateTime endTime;
    //Блок кнопок зафиксировавших происшествие
    @OneToOne
    @JoinColumn(name = "bevent_id", referencedColumnName = "id")
    private ButtonEvents bEventId;

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
     * Возвращает комментарий
     * @return
     * комментарий
     */
    public String getDescription() {
        return description;
    }

    /**
     * Устанавливает комментарий
     * @param description
     * комментарий
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Возвращает имя пользователя
     * @return
     * имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Устанавливает имя пользователя
     * @param username
     * имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Возвращает время фиксации
     * @return
     * время фиксации состояния
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Устанавливает время фиксации
     * @param timestamp
     * время фиксации состояния
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Возвращает тип происшествия
     * @return
     * тип происшествия
     */
    public AccidentClasses getATypeId() {
        return aTypeId;
    }

    /**
     * Устанавливает тип происшествия
     * @param aTypeId
     * тип происшествия
     */
    public void setATypeId(AccidentClasses aTypeId) {
        this.aTypeId = aTypeId;
    }

    /**
     * Возвращает следующую версию происшествия
     * @return
     * следующая версия происшествия
     */
    public Accidents getNextVersionId() {
        return NextVersionId;
    }

    /**
     * Устанавливает следующую версию происшествия
     * @param nextVersionId
     * следующая версия происшествия
     */
    public void setNextVersionId(Accidents nextVersionId) {
        NextVersionId = nextVersionId;
    }

    /**
     * Возвращает время начала происшествия
     * @return
     * время начала происшествия
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     * Устанавливает время начала происшествия
     * @param startTime
     * время начала происшествия
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Возвращает время конца происшествия
     * @return
     * время конца происшествия
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * Устанавливает время конца происшествия
     * @param endTime
     * время конца происшествия
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Возвращает блок кнопок зафиксировавших происшествие
     * @return
     * Блок кнопок зафиксировавших происшествие
     */
    public ButtonEvents getBEventId() {
        return bEventId;
    }

    /**
     * Устанавливает блок кнопок зафиксировавших происшествие
     * @param bEventId
     * Блок кнопок зафиксировавших происшествие
     */
    public void setBEventId(ButtonEvents bEventId) {
        this.bEventId = bEventId;
    }
}
