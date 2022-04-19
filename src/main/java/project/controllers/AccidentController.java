package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import project.dto.AccidentToFind;
import project.entities.Accidents;
import project.services.AccidentService;

import java.util.List;

/**
 * Контроллер отвечающий за работу с происшествиями
 *
 */
@Controller
public class AccidentController {

    // Сервис для работы с происшествиями
    @Autowired
    AccidentService accidentService;

    /**
     * метод возвращаю общее кол-во происшествий сохраненных в системе
     *
     * @return количество происшествий
     */
    @GetMapping("/count")
    @ResponseBody
    public Long number() {
        return accidentService.getAccidentsNumber();
    }

    /**
     *  метод возвращающий все происшествия в заданом промежутке
     * @param accident
     *      ДТО сущность, в которой передается промежуток происшестувий для вывода
     * @return
     *      список происшествий в заданном промежутке
     */
    @PostMapping("/testaccidents")
    @ResponseBody
    public List<Accidents> getaccidents(@RequestBody AccidentToFind accident) {
        List<Accidents> ventil = accidentService.getAccidents(accident);
        return ventil;
    }

    /**
     *  метод для редактирования происшествий
     * @param accident
     *      Дто сущность, в которой передаются обновленные параметры
     */
    @PostMapping("/updateaccidents")
    @ResponseBody
    public void updateaccidents(@RequestBody AccidentToFind accident) {
        accidentService.updateAccident(accident);
    }

    /**
     * Получение предыдущих состояний происшествия
     * @param accident
     *      Дто сущность, в которой передается идентификатор сущности, для которой мы ищем предыдущие состояния
     * @return
     *      предыдущие состояния происшествия
     */
    @PostMapping("/getpreviusstates")
    @ResponseBody
    public Accidents getpreviusstates(@RequestBody AccidentToFind accident) {
        return accidentService.getPreviousStates(accident);
    }

    /**
     *  Фильтрованные происшествия
     * @param accident
     *      Дто сущность, в которой передаются параметры фильтрации
     * @return
     *      Отфильтрованные происшествия
     */
    @PostMapping("/accidentfiltered")
    @ResponseBody
    public List<Object>  accidents(@RequestBody AccidentToFind accident) {
        return accidentService.getAccidentsFiltered(accident);
    }
}
