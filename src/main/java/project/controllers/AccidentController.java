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

@Controller
public class AccidentController {
    @Autowired
    AccidentService accidentService;


    @GetMapping("/count")
    @ResponseBody
    public Long number() {
        return accidentService.getAccidentsNumber();
    }

    @PostMapping("/testaccidents")
    @ResponseBody
    public List<Accidents> getaccidents(@RequestBody AccidentToFind accident) {
        List<Accidents> ventil = accidentService.getAccidents(accident);
        return ventil;
    }

    @PostMapping("/updateaccidents")
    @ResponseBody
    public void updateaccidents(@RequestBody AccidentToFind accident) {
        accidentService.updateAccident(accident);
    }

    @PostMapping("/getpreviusstates")
    @ResponseBody
    public Accidents getpreviusstates(@RequestBody AccidentToFind accident) {
        return accidentService.getPreviousStates(accident);
    }
    

    @PostMapping("/accidentfiltered")
    @ResponseBody
    public List<Object>  accidents(@RequestBody AccidentToFind accident) {
        return accidentService.getAccidentsFiltered(accident);
    }
}
