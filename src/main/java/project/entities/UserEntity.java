package project.entities;

import com.sun.istack.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

/**
 * Сущность пользователя
 */
@Entity
@Table(name = "userstable")
public class UserEntity implements UserDetails {
    //Уровень доступа пользователя
    @Column(name = "accesslist")
    private String accesslist;

    // Имя пользователя
    @Column(name = "name")
    @NotNull
    private String name;

    //Пароль пользователя
    @Column(name = "pwd")
    @NotNull
    private String pwd;

    // Идентификатор пользователя
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
     * Возвращает уровень доступа пользователя
     * @return
     * уровень доступа пользователя
     */
    public String getAccesslist() {
        return accesslist;
    }

    /**
     * Устанавливает уровень доступа пользователя
     * @param accesslist
     * уровень доступа пользователя
     */
    public void setAccesslist(String accesslist) {
        this.accesslist = accesslist;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * Возвращает пароль пользователя
     * @return
     * пароль пользователя
     */
    @Override
    public String getPassword() {
        return pwd;
    }

    /**
     * Возвращает имя пользователя
     * @return
     * имя пользователя
     */
    @Override
    public String getUsername() {
        return name;
    }

    /**
     * Проверяет не просрочен ли аккаунт
     * @return
     * состояние аккаунта
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Проверяет не заблокирован ли аккаунт
     * @return
     * состояние аккаунта
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Проверяет не просрочены ли данные аккаунт
     * @return
     * состояние аккаунта
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Проверяет активен ли аккаунт
     * @return
     * состояние аккаунта
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
