package project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.dto.ButtonsCondtionForFront;
import project.services.ButtonEventsService;

import java.io.IOException;
import java.util.List;

@RestController
public class MonitoringController {
    @Autowired
    ButtonEventsService buttonEventsService;

    @GetMapping("/monitoring")
    public List<ButtonsCondtionForFront> buttonsCondition() throws IOException {
        return buttonEventsService.getButtonConditions();
    }

}
