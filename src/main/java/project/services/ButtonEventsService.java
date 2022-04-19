package project.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import project.dto.ButtonsCondtionForFront;
import project.entities.ButtonEvents;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Service
public class ButtonEventsService {
    private final AccidentService accidentService;
    protected SessionFactory sessionFactory;
    private Session session;

    public ButtonEventsService(SessionFactory sessionFactory, AccidentService accidentService) {
        this.sessionFactory = sessionFactory;
        this.accidentService = accidentService;
    }

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();

    }

    @PreDestroy
    public void unSession() {
        session.close();
    }

    public List<ButtonsCondtionForFront> getButtonConditions() throws IOException {
        List<ButtonsCondtionForFront> conditionForFronts = new ArrayList<>();
        JSONArray jArray = new JSONArray(this.getButtonFile());
        for (int i = 0; i < 20; i++) {
            ButtonsCondtionForFront buttonsCondtionForFront = new ButtonsCondtionForFront();
            buttonsCondtionForFront.setNumber(i + 1);
            JSONObject jButton = jArray.getJSONObject(i);
            ButtonEvents button = GetButton(i);
            if (jButton.getInt("btype") == 3) {
                if (button.getBtype() != 3)
                    accidentService.addAccident(button.getNumber());
                buttonsCondtionForFront.setBtype(3);
                button.setBtype(3);
                button.setCounter3(jButton.getInt("counter3"));
                button.setCounter2(jButton.getInt("counter2"));
                button.setCounter1(jButton.getInt("counter1"));
                button.setTimestamp(new Timestamp(System.currentTimeMillis()));
            } else if (jButton.getInt("btype") == 2) {
                if (button.getBtype() == 3)
                    accidentService.closeAccident(button.getNumber());
                buttonsCondtionForFront.setBtype(2);
                button.setBtype(2);
                button.setCounter3(jButton.getInt("counter3"));
                button.setCounter2(jButton.getInt("counter2"));
                button.setCounter1(jButton.getInt("counter1"));
                button.setTimestamp(new Timestamp(System.currentTimeMillis()));
            } else if (jButton.getInt("btype") == 1) {
                if (button.getBtype() == 3)
                    accidentService.closeAccident(button.getNumber());
                buttonsCondtionForFront.setBtype(1);
                button.setBtype(1);
                button.setCounter3(jButton.getInt("counter3"));
                button.setCounter2(jButton.getInt("counter2"));
                button.setCounter1(jButton.getInt("counter1"));
                button.setTimestamp(new Timestamp(System.currentTimeMillis()));
            }
            conditionForFronts.add(buttonsCondtionForFront);
            this.SaveButton(button);
        }
        return conditionForFronts;
    }

    public ButtonEvents GetButton(int number) {
        List<ButtonEvents> check = session.createQuery("select m from ButtonEvents m where m.number='" + number + "'", ButtonEvents.class).list();
        if (check.size() == 0) {
            return null;
        } else
            return check.get(0);
    }

    public void SaveButton(ButtonEvents button) {
        session.clear();
        try {
            session.beginTransaction();
        }
        catch (Exception e){
        }
        session.saveOrUpdate(button);
        session.getTransaction().commit();
    }

    public String getButtonFile() throws IOException {
        URL url = new URL("https://emukurs.herokuapp.com/buttons");
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;
        inputLine = in.readLine();
        in.close();
        return inputLine;
    }
}
