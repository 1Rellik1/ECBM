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

@Service
public class UserService implements UserDetailsService {
    private static final String errorDeleteMassage = "Пользователь не может быть удален";
    private static final String deleteMassage = "Пользователь удален";
    @Autowired
    protected SessionFactory sessionFactory;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    private Session session;
    private CriteriaBuilder builder;
    private CriteriaQuery<UserEntity> timeCriteriaQuery;
    private Root<UserEntity> root;

    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
        timeCriteriaQuery = builder.createQuery(UserEntity.class);
        root = timeCriteriaQuery.from(UserEntity.class);
    }

    @PreDestroy
    public void unSession() {
        session.close();
    }

    public List<UserEntity> getUsers() {
        return session.createQuery("SELECT m from UserEntity m", UserEntity.class).getResultList();
    }

    public UserEntity getUser(UserToFind userToFind) {
        return session.load(UserEntity.class, userToFind.getId());
    }

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

    public Object checkAuth(UserToFind userForAuth) {
        Boolean authed = false;
        List<UserEntity> users = session.createQuery(timeCriteriaQuery.select(root).where(builder.equal(root.get("name"), userForAuth.getName()))).getResultList();
        if (users.size() == 0) {
            return ("User not found");
        } else {
            for (UserEntity user : users) {
                if (bCryptPasswordEncoder.matches(userForAuth.getPwd(), user.getPwd())) {
                    authed = true;
                }
            }
        }
        if (authed)
            return ("Логин и пароль введены верно");
        else
            return "Smth is wrong";
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<UserEntity> users = session.createQuery(timeCriteriaQuery.select(root).where(builder.equal(root.get("name"), s))).getResultList();
        return users.get(0);
    }
}
