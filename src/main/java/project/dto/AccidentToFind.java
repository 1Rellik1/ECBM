package project.dto;

import java.time.LocalDateTime;

public class AccidentToFind {
    private int id;
    private String description;
    private Integer post;
    private String username;
    private Integer aTypeId;
    private LocalDateTime end_time;
    private LocalDateTime start_time;
    private int startprom;
    private int endprom;
    private LocalDateTime accidentdatefirst;
    private LocalDateTime accidentdatesecond;
    private LocalDateTime accidentdatefirstend;
    private LocalDateTime accidentdatesecondend;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getaTypeId() {
        return aTypeId;
    }

    public void setaTypeId(Integer aTypeId) {
        this.aTypeId = aTypeId;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public int getStartprom() {
        return startprom;
    }

    public void setStartprom(int startprom) {
        this.startprom = startprom;
    }

    public int getEndprom() {
        return endprom;
    }

    public void setEndprom(int endprom) {
        this.endprom = endprom;
    }

    public LocalDateTime getAccidentdatefirst() {
        return accidentdatefirst;
    }

    public void setAccidentdatefirst(LocalDateTime accidentdatefirst) {
        this.accidentdatefirst = accidentdatefirst;
    }

    public LocalDateTime getAccidentdatesecond() {
        return accidentdatesecond;
    }

    public void setAccidentdatesecond(LocalDateTime accidentdatesecond) {
        this.accidentdatesecond = accidentdatesecond;
    }

    public LocalDateTime getAccidentdatefirstend() {
        return accidentdatefirstend;
    }

    public void setAccidentdatefirstend(LocalDateTime accidentdatefirstend) {
        this.accidentdatefirstend = accidentdatefirstend;
    }

    public LocalDateTime getAccidentdatesecondend() {
        return accidentdatesecondend;
    }

    public void setAccidentdatesecondend(LocalDateTime accidentdatesecondend) {
        this.accidentdatesecondend = accidentdatesecondend;
    }
}
