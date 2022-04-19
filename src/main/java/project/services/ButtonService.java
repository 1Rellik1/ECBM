package project.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import project.entities.ButtonEntity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

/**
 * Сервис для работы с блоками кнопок
 */
@Service
public class ButtonService {
    //Фабрика сессий
    protected SessionFactory sessionFactory;

    //Сессия
    private Session session;

    /**
     * Конструктора
     * @param sessionFactory
     * фабрика сессий
     */
    public ButtonService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Постконструктор
     */
    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }

    /**
     * Предестройер
     */
    @PreDestroy
    public void unSession() {
        session.close();
    }

    /**
     * Получение блока кнопок по его номер
     * @param number
     * номер блока кнопки
     * @return
     * блок кнопок
     */
    public List<ButtonEntity> getButton(int number) {
        return session.createQuery("select m from ButtonEntity m where m.number='" + number + "'").getResultList();
    }
}
