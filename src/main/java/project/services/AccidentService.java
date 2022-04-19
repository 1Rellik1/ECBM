package project.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import project.dto.AccidentToFind;
import project.entities.AccidentClasses;
import project.entities.Accidents;
import project.entities.ButtonEntity;
import project.entities.ButtonEvents;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервис для работы с происшествиями
 */
@Service
public class AccidentService {
    //Сервис для работы с блоками кнопок
    private final ButtonService buttonService;
    //Фабрика сессий
    protected SessionFactory sessionFactory;
    //Сессия
    private Session session;
    //Билдер критериев запроса
    private CriteriaBuilder builder;
    //Запрос по критериям
    private CriteriaQuery<Accidents> timeCriteriaQuery;
    //Корневая сущность запроса
    private Root<Accidents> root;

    /**
     * Конструктора
     * @param sessionFactory
     * фабрика сессий
     * @param buttonService
     * сервис для работы с блоками кнопок
     */
    public AccidentService(SessionFactory sessionFactory, ButtonService buttonService) {
        this.sessionFactory = sessionFactory;
        this.buttonService = buttonService;
    }

    /**
     * Постконструктор
     */
    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
        timeCriteriaQuery = builder.createQuery(Accidents.class);
        root = timeCriteriaQuery.from(Accidents.class);
    }

    /**
     * Предестройер
     */
    @PreDestroy
    public void unSession() {
        session.close();
    }

    /**
     * метод возвращающий все происшествия в заданом промежутке
     * @param accident
     * ДТО сущность, в которой передается промежуток происшестувий для вывода
     * @return
     * список происшествий в заданном промежутке
     */
    public  List<Accidents> getAccidents(AccidentToFind accident) {
        List<Accidents> listOfAccidents = this.session.createQuery("SELECT m from Accidents m where m.NextVersionId is null order by m.startTime desc", Accidents.class).list();
        if (listOfAccidents.size() > 0) {
            if (accident.getEndprom() > listOfAccidents.size())
                accident.setEndprom(listOfAccidents.size());
            return listOfAccidents.subList(accident.getStartprom() - 1, accident.getEndprom());
        } else return listOfAccidents;
    }

    /**
     * метод возвращаю общее кол-во происшествий сохраненных в системе
     * @return
     * количество происшествий
     */
    public Long getAccidentsNumber() {
        return session.createQuery("SELECT count(m) from Accidents m where m.NextVersionId is null", java.lang.Long.class).getSingleResult();
    }

    /**
     * Фильтрованные происшествия
     * @param accident
     * Дто сущность, в которой передаются параметры фильтрации
     * @return
     * Отфильтрованные происшествия
     */
    public List<Object>  getAccidentsFiltered(AccidentToFind accident) {
        List<Accidents> resultList = null;
        Long number=null;
        System.out.println(accident.getAccidentdatefirst());
        if (accident.getPost() != null & accident.getAccidentdatefirstend() != null & accident.getAccidentdatesecondend() != null & accident.getaTypeId() != null & accident.getAccidentdatefirst() != null & accident.getAccidentdatesecond() != null) {
            number=session.createQuery("SELECT count(m) from Accidents m where m.post='" + accident.getPost() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirstend() + "'and'" + accident.getAccidentdatesecondend() + "'and m.aTypeId='" + accident.getaTypeId() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirst() + "'and'" + accident.getAccidentdatesecond() + "'and m.NextVersionId is null ", java.lang.Long.class).getSingleResult();
            resultList = session.createQuery("select m from Accidents m where m.post='" + accident.getPost() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirstend() + "'and'" + accident.getAccidentdatesecondend() + "'and m.aTypeId='" + accident.getaTypeId() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirst() + "'and'" + accident.getAccidentdatesecond() + "'and m.NextVersionId is null order by m.startTime desc", Accidents.class).list();
        }
        else if (accident.getPost() != null & accident.getAccidentdatefirstend() != null & accident.getAccidentdatesecondend() != null  & accident.getAccidentdatefirst() != null & accident.getAccidentdatesecond() != null) {
            number = session.createQuery("SELECT count(m) from Accidents m where m.post='" + accident.getPost() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirstend() + "'and'" + accident.getAccidentdatesecondend() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirst() + "'and'" + accident.getAccidentdatesecond() + "'and m.NextVersionId is null ", java.lang.Long.class).getSingleResult();
            resultList = session.createQuery("select m from Accidents m where m.post='" + accident.getPost() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirstend() + "'and'" + accident.getAccidentdatesecondend() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirst() + "'and'" + accident.getAccidentdatesecond() + "'and m.NextVersionId is null order by m.startTime desc", Accidents.class).list();
        }
        else if (accident.getPost() != null & accident.getAccidentdatefirst() != null & accident.getAccidentdatesecond() != null & accident.getaTypeId() != null) {
            number=session.createQuery("SELECT count(m) from Accidents m where m.post='" + accident.getPost() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirst() + "'and'" + accident.getAccidentdatesecond() + "'and m.aTypeId='" + accident.getaTypeId() + "'and m.NextVersionId is null ", java.lang.Long.class).getSingleResult();
            resultList = session.createQuery("select m from Accidents m where m.post='" + accident.getPost() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirst() + "'and'" + accident.getAccidentdatesecond() + "'and m.aTypeId='" + accident.getaTypeId() + "'and m.NextVersionId is null order by m.startTime desc", Accidents.class).list();
        } else if (accident.getPost() != null & accident.getAccidentdatefirstend() != null & accident.getAccidentdatesecondend() != null & accident.getaTypeId() != null) {
            number=session.createQuery("SELECT count(m) from Accidents m where m.post='" + accident.getPost() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirstend() + "'and'" + accident.getAccidentdatesecondend() + "'and m.aTypeId='" + accident.getaTypeId() + "'and m.NextVersionId is null ", java.lang.Long.class).getSingleResult();
            resultList = session.createQuery("select m from Accidents m where m.post='" + accident.getPost() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirstend() + "'and'" + accident.getAccidentdatesecondend() + "'and m.aTypeId='" + accident.getaTypeId() + "'and m.NextVersionId is null order by m.startTime desc", Accidents.class).list();
        } else if (accident.getaTypeId() != null & accident.getAccidentdatefirst() != null & accident.getAccidentdatesecond() != null & accident.getaTypeId() != null & accident.getAccidentdatefirstend() != null & accident.getAccidentdatesecondend() != null) {
            number=session.createQuery("SELECT count(m) from Accidents m where m.aTypeId='" + accident.getaTypeId() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirst() + "'and'" + accident.getAccidentdatesecond() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirstend() + "'and'" + accident.getAccidentdatesecondend() + "'and m.NextVersionId is null", java.lang.Long.class).getSingleResult();
            resultList = session.createQuery("select m from Accidents m where m.aTypeId='" + accident.getaTypeId() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirst() + "'and'" + accident.getAccidentdatesecond() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirstend() + "'and'" + accident.getAccidentdatesecondend() + "'and m.NextVersionId is null order by m.startTime desc", Accidents.class).list();
        } else if (accident.getAccidentdatefirstend() != null & accident.getAccidentdatesecondend() != null & accident.getAccidentdatefirst() != null & accident.getAccidentdatesecond() != null) {
            number=session.createQuery("SELECT count(m) from Accidents m where m.endTime BETWEEN '" + accident.getAccidentdatefirstend() + "'and'" + accident.getAccidentdatesecondend() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirst() + "'and'" + accident.getAccidentdatesecond() + "'and m.NextVersionId is null", java.lang.Long.class).getSingleResult();
            resultList = session.createQuery("select m from Accidents m where m.endTime BETWEEN '" + accident.getAccidentdatefirstend() + "'and'" + accident.getAccidentdatesecondend() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirst() + "'and'" + accident.getAccidentdatesecond() + "'and m.NextVersionId is null order by m.startTime desc", Accidents.class).list();
        } else if (accident.getPost() != null & accident.getAccidentdatefirst() != null & accident.getAccidentdatesecond() != null) {
            number=session.createQuery("SELECT count(m) from Accidents m where m.post='" + accident.getPost() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirst() + "'and'" + accident.getAccidentdatesecond() + "'and m.NextVersionId is null ", java.lang.Long.class).getSingleResult();
            resultList = session.createQuery("select m from Accidents m where m.post='" + accident.getPost() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirst() + "'and'" + accident.getAccidentdatesecond() + "'and m.NextVersionId is null order by m.startTime desc", Accidents.class).list();
        } else if (accident.getPost() != null & accident.getAccidentdatefirstend() != null & accident.getAccidentdatesecondend() != null) {
            System.out.println(accident.getAccidentdatefirstend());
            number=session.createQuery("SELECT count(m) from Accidents m where m.post='" + accident.getPost() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirstend() + "'and'" + accident.getAccidentdatesecondend() + "'and m.NextVersionId is null ", java.lang.Long.class).getSingleResult();
            resultList = session.createQuery("select m from Accidents m where m.post='" + accident.getPost() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirstend() + "'and'" + accident.getAccidentdatesecondend() + "'and m.NextVersionId is null order by m.startTime desc", Accidents.class).list();
        } else if (accident.getaTypeId() != null & accident.getAccidentdatefirst() != null & accident.getAccidentdatesecond() != null) {
            number=session.createQuery("SELECT count(m) from Accidents m where m.aTypeId='" + accident.getaTypeId() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirst() + "'and'" + accident.getAccidentdatesecond() + "'and m.NextVersionId is null ", java.lang.Long.class).getSingleResult();
            resultList = session.createQuery("select m from Accidents m where m.aTypeId='" + accident.getaTypeId() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirst() + "'and'" + accident.getAccidentdatesecond() + "'and m.NextVersionId is null order by m.startTime desc", Accidents.class).list();
        } else if (accident.getaTypeId() != null & accident.getAccidentdatefirstend() != null & accident.getAccidentdatesecondend() != null) {
            number=session.createQuery("SELECT count(m) from Accidents m where m.aTypeId='" + accident.getaTypeId() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirstend() + "'and'" + accident.getAccidentdatesecondend() + "'and m.NextVersionId is null", java.lang.Long.class).getSingleResult();
            resultList = session.createQuery("select m from Accidents m where m.aTypeId='" + accident.getaTypeId() + "'and m.startTime BETWEEN '" + accident.getAccidentdatefirstend() + "'and'" + accident.getAccidentdatesecondend() + "'and m.NextVersionId is null order by m.startTime desc", Accidents.class).list();
        } else if (accident.getPost() != null & accident.getaTypeId() != null) {
            number=session.createQuery("SELECT count(m) from Accidents m where m.post='" + accident.getPost() + "'and m.aTypeId='" + accident.getaTypeId() + "'and m.NextVersionId is null ", java.lang.Long.class).getSingleResult();
            resultList = session.createQuery("select m from Accidents m where m.post='" + accident.getPost() + "'and m.aTypeId='" + accident.getaTypeId() + "'and m.NextVersionId is null order by m.startTime desc", Accidents.class).list();
        } else if (accident.getPost() != null) {
            number=session.createQuery("SELECT count(m) from Accidents m where m.post='" + accident.getPost() + "'and m.NextVersionId is null " , java.lang.Long.class).getSingleResult();
            resultList = session.createQuery("select m from Accidents m where m.post='" + accident.getPost() + "'and m.NextVersionId is null order by m.startTime desc", Accidents.class).list();
        } else if (accident.getaTypeId() != null) {
            number=session.createQuery("SELECT count(m) from Accidents m where m.aTypeId='" + accident.getaTypeId() + "'and m.NextVersionId is null", java.lang.Long.class).getSingleResult();
            resultList = session.createQuery("select m from Accidents m where m.aTypeId='" + accident.getaTypeId() + "'and m.NextVersionId is null order by m.startTime desc", Accidents.class).list();
        } else if (accident.getAccidentdatefirst() != null & accident.getAccidentdatesecond() != null) {
            number=session.createQuery("SELECT count(m) from Accidents m where m.startTime BETWEEN '" + accident.getAccidentdatefirst() + "'and'" + accident.getAccidentdatesecond() + "'and m.NextVersionId is null", java.lang.Long.class).getSingleResult();
            resultList = session.createQuery("select m from Accidents m where m.startTime BETWEEN '" + accident.getAccidentdatefirst() + "'and'" + accident.getAccidentdatesecond() + "'and m.NextVersionId is null order by m.startTime desc", Accidents.class).list();
        } else if (accident.getAccidentdatefirstend() != null & accident.getAccidentdatesecondend() != null) {
            number=session.createQuery("SELECT count(m) from Accidents m where m.endTime BETWEEN '" + accident.getAccidentdatefirstend() + "'and'" + accident.getAccidentdatesecondend() + "'and m.NextVersionId is null", java.lang.Long.class).getSingleResult();
            resultList = session.createQuery("select m from Accidents m where m.endTime BETWEEN '" + accident.getAccidentdatefirstend() + "'and'" + accident.getAccidentdatesecondend() + "'and m.NextVersionId is null order by m.startTime desc", Accidents.class).list();
        }
        if (resultList.size() > 0) {
            if (accident.getEndprom() > resultList.size())
                accident.setEndprom(resultList.size());
            resultList= resultList.subList(accident.getStartprom() - 1, accident.getEndprom());
        }
        List<Object> entitiesWithNumber = new ArrayList<>();
        entitiesWithNumber.add(number);
        entitiesWithNumber.add(resultList);
        return entitiesWithNumber;
    }

    /**
     * Получение предыдущих состояний происшествия
     * @param accident
     * Дто сущность, в которой передается идентификатор сущности, для которой мы ищем предыдущие состояния
     * @return
     * предыдущие состояния происшествия
     */
    public Accidents getPreviousStates(AccidentToFind accident) {
        Predicate[] predicates = new Predicate[2];
        Accidents latest_accident = session.load(Accidents.class, accident.getId());
        predicates[0] = builder.equal(root.get("post"), latest_accident.getPost());
        predicates[1] = builder.equal(root.get("startTime"), latest_accident.getStartTime());
        List<Accidents> allStates = session.createQuery(timeCriteriaQuery.select(root).where(predicates)).getResultList();
        Accidents first_state = allStates.get(0);
        for (Accidents accidents1 : allStates) {
            if (accidents1.getTimestamp().compareTo(first_state.getTimestamp()) < 0) {
                first_state = accidents1;
            }
        }
        return first_state;
    }

    /**
     * Добавление происшествия
     * @param number
     * номер блока кнопок
     */
    public void addAccident(int number) {
        List<ButtonEntity> buttonWithPosts = buttonService.getButton(number);
        for (ButtonEntity button : buttonWithPosts) {
            Accidents accident = new Accidents();
            int post;
            if (button.getSide()) {
                accident.setPost(button.getPost() + 14);
                accident.setBEventId(session.load(ButtonEvents.class,button.getNumber()+1));
            }
            else
                accident.setPost(button.getPost());
            accident.setUsername("Красная кнопка");
            accident.setStartTime(LocalDateTime.now());
            accident.setTimestamp(LocalDateTime.now());
            session.beginTransaction();
            session.saveOrUpdate(accident);
            session.getTransaction().commit();
        }
    }

    /**
     * Закрытие происшествия
     * @param number
     * номер блока кнопок
     */
    public void closeAccident(int number) {
        List<ButtonEntity> buttonWithPosts = buttonService.getButton(number);
        for (ButtonEntity button : buttonWithPosts) {
            List<Accidents> latestAccidents;
            if (button.getSide()) {
                int post = button.getPost() + 14;
                latestAccidents = session.createQuery("select m from Accidents m where m.post='" + post + "'and m.NextVersionId is null and m.endTime is null").getResultList();
            } else
                latestAccidents = session.createQuery("select m from Accidents m where m.post='" + button.getPost() + "'and m.NextVersionId is null and m.endTime is null").getResultList();
            if (latestAccidents.size() != 0) {
                Accidents latestAccident = latestAccidents.get(0);
                Accidents newAccident = new Accidents();
                List<Accidents> accidentsList = session.createQuery("SELECT m from Accidents m", Accidents.class).getResultList();
                for (Accidents accidents1 : accidentsList) {
                    while (accidents1.getId() == newAccident.getId()) {
                        newAccident.setId(newAccident.getId() + 1);
                    }
                }
                newAccident.setStartTime(latestAccident.getStartTime());
                newAccident.setDescription(latestAccident.getDescription());
                newAccident.setTimestamp(LocalDateTime.now());
                newAccident.setEndTime(LocalDateTime.now());
                newAccident.setPost(latestAccident.getPost());
                newAccident.setUsername("инцидент устранен");
                newAccident.setBEventId(latestAccident.getBEventId());
                newAccident.setATypeId(latestAccident.getATypeId());
                session.clear();
                session.beginTransaction();
                session.saveOrUpdate(newAccident);
                latestAccident.setNextVersionId(newAccident);
                session.saveOrUpdate(latestAccident);
                session.getTransaction().commit();
            }
        }
    }

    /**
     * метод для редактирования происшествий
     * @param accidents
     *   Дто сущность, в которой передаются обновленные параметры
     */
    public void updateAccident(AccidentToFind accidents) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Accidents latestAccident = session.load(Accidents.class, accidents.getId());
        Accidents newAccident = new Accidents();
        List<Accidents> accidentsList = session.createQuery("SELECT m from Accidents m", Accidents.class).getResultList();
        for (Accidents accidents1 : accidentsList) {
            while (accidents1.getId() == newAccident.getId()) {
                newAccident.setId(newAccident.getId() + 1);
            }
        }
        newAccident.setStartTime(latestAccident.getStartTime());
        newAccident.setDescription(accidents.getDescription());
        newAccident.setTimestamp(LocalDateTime.now());
        newAccident.setEndTime(accidents.getEnd_time());
        newAccident.setPost(latestAccident.getPost());
        newAccident.setUsername(currentPrincipalName);
        newAccident.setBEventId(latestAccident.getBEventId());
        newAccident.setEndTime(latestAccident.getEndTime());
        if(accidents.getaTypeId()!= null) {
            newAccident.setATypeId(session.createQuery("select m from AccidentClasses m where m.id = " + accidents.getaTypeId(), AccidentClasses.class).getSingleResult());
        }
        session.clear();
        session.beginTransaction();
        session.saveOrUpdate(newAccident);
        latestAccident.setNextVersionId(newAccident);
        session.saveOrUpdate(latestAccident);
        session.getTransaction().commit();
    }

}
