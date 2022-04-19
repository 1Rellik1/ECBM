package project.dto;

/**
 *  Дто сущность пользователя
 */
public class UserToFind {
    // Имя пользователя
    private String name;
    //Пароль пользователя
    private String pwd;
    //Уровень доступа пользователя
    private String accessList;
    //Обновленное имя пользователя
    private String newName;
    //Обновленный уровень доступа пользователя
    private String newAccessList;
    //Обновленный пароль пользователя
    private String newPwd;
    // Идентификатор пользователя
    private int id;

    /**
     * Возвращает имя пользователя
     * @return
     * имя пользователя
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя пользователя
     * @param name
     * имя пользователя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает пароль пользователя
     * @return
     * пароль пользователя
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * Устанавливает пароль пользователя
     * @param pwd
     *  пароль пользователя
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * Возвращает уровень доступа пользователя
     * @return
     * уровень доступа пользователя
     */
    public String getAccessList() {
        return accessList;
    }

    /**
     * Устанавливает уровень доступа пользователя
     * @param accessList
     * уровень доступа пользователя
     */
    public void setAccessList(String accessList) {
        this.accessList = accessList;
    }

    /**
     * Возвращает обновленное имя пользователя
     * @return
     * имя пользователя
     */
    public String getNewName() {
        return newName;
    }

    /**
     * Устанавливает обновленное имя пользователя
     * @param newName
     * обновленное имя пользователя
     */
    public void setNewName(String newName) {
        this.newName = newName;
    }

    /**
     * Возвращает обновленный уровень доступа пользователя
     * @return
     * обновленный уровень доступа пользователя
     */
    public String getNewAccessList() {
        return newAccessList;
    }

    /**
     * Устанавливает обновленный уровень доступа пользователя
     * @param newAccessList
     *  обновленный уровень доступа пользователя
     */
    public void setNewAccessList(String newAccessList) {
        this.newAccessList = newAccessList;
    }

    /**
     * Возвращает идентификатор пользователя
     * @return
     * идентификатор пользователя
     */
    public int getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор пользователя-
     * @param id
     * идентификатор пользователя
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Возвращает обновленный пароль пользователя
     * @return
     * пароль пользователя
     */
    public String getNewPwd() {
        return newPwd;
    }

    /**
     * Устанавливает обновленный пароль пользователя
     * @param newPwd
     * обновленный пароль пользователя
     */
    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}
