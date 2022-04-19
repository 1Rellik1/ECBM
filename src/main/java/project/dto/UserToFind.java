package project.dto;

public class UserToFind {
    private String name;
    private String pwd;
    private String accessList;
    private String newName;
    private String newAccessList;
    private String newPwd;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAccessList() {
        return accessList;
    }

    public void setAccessList(String accessList) {
        this.accessList = accessList;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewAccessList() {
        return newAccessList;
    }

    public void setNewAccessList(String newAccessList) {
        this.newAccessList = newAccessList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}
