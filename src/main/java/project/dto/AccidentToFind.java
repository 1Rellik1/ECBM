package project.dto;

import project.entities.AccidentClasses;

import java.time.LocalDateTime;

/**
 *  Дто сущность происшествий
 */
public class AccidentToFind {
    //идентификатор происшествия
    private int id;
    //комментарий
    private String description;
    //пост
    private Integer post;
    //имя пользователя
    private String username;
    //тип происшествия
    private Integer aTypeId;
    //время конца происшествия
    private LocalDateTime end_time;
    //время начала происшествия
    private LocalDateTime start_time;
    //начало промежутка
    private int startprom;
    //конец промежутка
    private int endprom;
    //время начала промежутка фильтрации по дате начала
    private LocalDateTime accidentdatefirst;
    //время конца промежутка фильтрации по дате начала
    private LocalDateTime accidentdatesecond;
    //время начала промежутка фильтрации по дате конца
    private LocalDateTime accidentdatefirstend;
    //время конца промежутка фильтрации по дате конца
    private LocalDateTime accidentdatesecondend;

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
     * Возвращает номер поста
     * @return
     * номер поста
     */
    public Integer getPost() {
        return post;
    }

    /**
     * Устанавливает номер поста
     * @param post
     * номер поста
     */
    public void setPost(Integer post) {
        this.post = post;
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
     * Возвращает тип происшествия
     * @return
     * тип происшествия
     */
    public Integer getaTypeId() {
        return aTypeId;
    }

    /**
     * Устанавливает тип происшествия
     * @param aTypeId
     * тип происшествия
     */
    public void setaTypeId(Integer aTypeId) {
        this.aTypeId = aTypeId;
    }

    /**
     * Возвращает время конца происшествия
     * @return
     * время конца происшествия
     */
    public LocalDateTime getEnd_time() {
        return end_time;
    }

    /**
     * Устанавливает время конца происшествия
     * @param end_time
     * время конца происшествия
     */
    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }

    /**
     * Возвращает время начала происшествия
     * @return
     * время начала происшествия
     */
    public LocalDateTime getStart_time() {
        return start_time;
    }

    /**
     * Устанавливает время начала происшествия
     * @param start_time
     * время начала происшествия
     */
    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    /**
     * Возвращает начало промежутка
     * @return
     * начало промежутка
     */
    public int getStartprom() {
        return startprom;
    }

    /**
     * Устанавливает начало промежутка
     * @param startprom
     * начало промежутка
     */
    public void setStartprom(int startprom) {
        this.startprom = startprom;
    }

    /**
     * Возвращает конец промежутка
     * @return
     * конец промежутка
     */
    public int getEndprom() {
        return endprom;
    }

    /**
     * Устанавливает конец промежутка
     * @param endprom
     * конец промежутка
     */
    public void setEndprom(int endprom) {
        this.endprom = endprom;
    }

    /**
     * Возвращает время начала промежутка фильтрации по дате начала
     * @return
     * время начала промежутка фильтрации по дате начала
     */
    public LocalDateTime getAccidentdatefirst() {
        return accidentdatefirst;
    }

    /**
     * Устанавливает время начала промежутка фильтрации по дате начала
     * @param accidentdatefirst
     * время начала промежутка фильтрации по дате начала
     */
    public void setAccidentdatefirst(LocalDateTime accidentdatefirst) {
        this.accidentdatefirst = accidentdatefirst;
    }

    /**
     * Возвращает время конца промежутка фильтрации по дате начала
     * @return
     * время конца промежутка фильтрации по дате начала
     */
    public LocalDateTime getAccidentdatesecond() {
        return accidentdatesecond;
    }

    /**
     * Устанавливает время конца промежутка фильтрации по дате начала
     * @param accidentdatesecond
     * время конца промежутка фильтрации по дате начала
     */
    public void setAccidentdatesecond(LocalDateTime accidentdatesecond) {
        this.accidentdatesecond = accidentdatesecond;
    }

    /**
     * Возвращает время начала промежутка фильтрации по дате конца
     * @return
     *  время начала промежутка фильтрации по дате конца
     */
    public LocalDateTime getAccidentdatefirstend() {
        return accidentdatefirstend;
    }

    /**
     * Устанавливает время начала промежутка фильтрации по дате конца
     * @param accidentdatefirstend
     * время начала промежутка фильтрации по дате конца
     */
    public void setAccidentdatefirstend(LocalDateTime accidentdatefirstend) {
        this.accidentdatefirstend = accidentdatefirstend;
    }

    /**
     * Возвращает время конца промежутка фильтрации по дате конца
     * @return
     * время конца промежутка фильтрации по дате конца
     */
    public LocalDateTime getAccidentdatesecondend() {
        return accidentdatesecondend;
    }

    /**
     * Устанавливает время конца промежутка фильтрации по дате конца
     * @param accidentdatesecondend
     * время конца промежутка фильтрации по дате конца
     */
    public void setAccidentdatesecondend(LocalDateTime accidentdatesecondend) {
        this.accidentdatesecondend = accidentdatesecondend;
    }
}
