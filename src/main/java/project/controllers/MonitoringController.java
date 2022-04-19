package project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.dto.ButtonsCondtionForFront;
import project.services.ButtonEventsService;

import java.io.IOException;
import java.util.List;

/**
 * Контроллер отвечающий за вывод состояния конвейера
 */
@RestController
public class MonitoringController {
    //Сервис для работы с состоянием постов
    @Autowired
    ButtonEventsService buttonEventsService;

    /**
     *  Метод возвращающий состояние конвейера в текущий момент времени
     * @return
     *      состояние конвейера в текущий момент времени
     * @throws IOException
     *      при неудачном получении состояния
     */
    @GetMapping("/monitoring")
    public List<ButtonsCondtionForFront> buttonsCondition() throws IOException {
        return buttonEventsService.getButtonConditions();
    }

}
