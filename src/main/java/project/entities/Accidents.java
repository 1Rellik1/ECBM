package project.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "accidents")
public class Accidents {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;

    @Column(name = "post")
    private int post;

    @Column(name = "description")
    private String description;

    @Column(name = "username")
    private String username;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @OneToOne
    @JoinColumn(name = "atype_id", referencedColumnName = "id")
    private AccidentClasses aTypeId;

    @OneToOne
    @JoinColumn(name = "nextversion_id", referencedColumnName = "id")
    private Accidents NextVersion_id;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @OneToOne
    @JoinColumn(name = "bevent_id", referencedColumnName = "id")
    private ButtonEvents bEventId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public AccidentClasses getATypeId() {
        return aTypeId;
    }

    public void setATypeId(AccidentClasses aTypeId) {
        this.aTypeId = aTypeId;
    }

    public Accidents getNextVersion_id() {
        return NextVersion_id;
    }

    public void setNextVersion_id(Accidents nextVersion_id) {
        NextVersion_id = nextVersion_id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public ButtonEvents getBEventId() {
        return bEventId;
    }

    public void setBEventId(ButtonEvents bEventId) {
        this.bEventId = bEventId;
    }
}
