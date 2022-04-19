package project.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import project.dto.UserToFind;
import project.entities.UserEntity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Сервис работы с пользователями
 */
@Service
public class UserService implements UserDetailsService {
    //Сообщение о невозможности удалить пользователя
    private static final String errorDeleteMassage = "Пользователь не может быть удален";
    //Сообщение об удаление пользователя
    private static final String deleteMassage = "Пользователь удален";
    //Фабрика сессий
    @Autowired
    protected SessionFactory sessionFactory;
    //Хэш кодировщик
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    //Сессия
    private Session session;
    //Билдер критериев запроса
    private CriteriaBuilder builder;
    //Запрос по критериям
    private CriteriaQuery<UserEntity> timeCriteriaQuery;
    //Корневая сущность запроса
    private Root<UserEntity> root;

    /**
     * Конструктора
     * @param sessionFactory
     * фабрика сессий
     */
    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Постконструктор
     */
    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
        timeCriteriaQuery = builder.createQuery(UserEntity.class);
        root = timeCriteriaQuery.from(UserEntity.class);
    }

    /**
     * Предестройер
     */
    @PreDestroy
    public void unSession() {
        session.close();
    }

    /**
     * Получение всех пользователей
     * @return
     * список пользователей
     */
    public List<UserEntity> getUsers() {
        return session.createQuery("SELECT m from UserEntity m", UserEntity.class).getResultList();
    }

    /**
     * Получение пользователя по идентификатору
     * @param userToFind
     * Дто сущность пользователя с его идентификатором
     * @return
     * найденный пользователь
     */
    public UserEntity getUser(UserToFind userToFind) {
        return session.load(UserEntity.class, userToFind.getId());
    }

    /**
     * Добавление пользователя
     * @param user
     * Дто сущность с данными нового пользователя
     * @return
     * сообщение о результате добавления
     */
    public String addUser(UserEntity user) {
        List<UserEntity> userlist = session.createQuery("SELECT m from UserEntity m", UserEntity.class).getResultList();
        UserEntity userfromdb = userlist.get(userlist.size() - 1);
        while (userfromdb.getId() == user.getId()) {
            user.setId(user.getId() + 1);
        }
        user.setPwd(bCryptPasswordEncoder.encode(user.getPwd()));
        session.clear();
        try {
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        }
        catch (Exception e){
            session.clear();
            session.getTransaction().commit();
            return "Пользователь с таких именем уже существует";
        }
        return "пользователь добавлен";
    }

    /**
     * Обновление данных пользователя
     * @param user
     * Дто сущность с обновленными данными пользователя
     * @return
     * результат обновления
     */
    public String updateUser(UserToFind user) {
   UserEntity temp = session.load(UserEntity.class, user.getId());
    int counter=0;
    List<UserEntity> userlist = session.createQuery("SELECT m from UserEntity m", UserEntity.class).getResultList();
    for (UserEntity i:userlist){
        if( i.getName().equals(user.getNewName()) && temp.getId()!=i.getId())
            counter++;
    }
    UserEntity principal = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (principal.getId()== temp.getId()){
        return "Нельзя обновить текущего пользователя";
    }
    if (counter==0) {
    if (user.getNewAccessList() != null)
        temp.setAccesslist(user.getNewAccessList());
    if (user.getNewName() != null)
        temp.setName(user.getNewName());
    if (user.getNewPwd() != null)
        temp.setPwd(bCryptPasswordEncoder.encode(user.getNewPwd()));
        session.beginTransaction();
        session.saveOrUpdate(temp);
        session.getTransaction().commit();
        return "User updated";
    }
    else return "Пользователь с таким именем уже существует";
    }

    /**
     * Удаление пользователя
     * @param user
     * Дто сущность пользователя с его идентификатором
     * @return
     * результат удаления
     */
    public String deleteUser(UserToFind user) {
        UserEntity temp = session.load(UserEntity.class, user.getId());
        UserEntity principal = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal.getId()== temp.getId()){
            return "Нельзя удалить текущего пользователя";
        }
        String access = temp.getAccesslist();
        Boolean onlyAdmin=true;
        Boolean notAdmin=true;
        if(access.charAt(0)=='1'){
            notAdmin=false;
            List<UserEntity> userlist = session.createQuery("SELECT m from UserEntity m", UserEntity.class).getResultList();
                for (UserEntity i:userlist){
                    if(i.getAccesslist() != null)
                        if( i.getAccesslist().charAt(0)=='1' )
                            onlyAdmin=false;
                }
        }
        if (!onlyAdmin || notAdmin) {
            this.session.clear();
            this.session.beginTransaction();
            this.session.delete(temp);
            this.session.getTransaction().commit();
            return UserService.deleteMassage;
        }
        else return UserService.errorDeleteMassage;
    }

    /**
     * Получение пользователя по его имени
     * @param s
     * имя пользователя
     * @return
     * Данные пользователя
     * @throws UsernameNotFoundException
     * Если пользователь не был найден
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<UserEntity> users = session.createQuery(timeCriteriaQuery.select(root).where(builder.equal(root.get("name"), s))).getResultList();
        return users.get(0);
    }
}
