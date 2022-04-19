package project.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import project.entities.ButtonEntity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class ButtonService {
    protected SessionFactory sessionFactory;

    private Session session;

    public ButtonService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }

    @PreDestroy
    public void unSession() {
        session.close();
    }

    public List<ButtonEntity> getButton(int number) {
        return session.createQuery("select m from ButtonEntity m where m.number='" + number + "'").getResultList();
    }
}
