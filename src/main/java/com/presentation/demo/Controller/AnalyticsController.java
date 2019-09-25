package com.presentation.demo.Controller;


import com.presentation.demo.Reponse;
import com.presentation.demo.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AnalyticsController {

    private final String topic = "events";

    @Autowired
    private KafkaTemplate <String, Event> kafkaTemplate;

    @GetMapping("/analytics")
    @ResponseBody
    public Reponse productDetail(@RequestParam(required = true) String type,
                                 @RequestParam(required = true) String source,
                                 @RequestParam(required = true) String userId,
                                 @RequestParam(required = true) String dateEvent,
                                 @RequestParam(required = false) String productId){

        Event event = new Event(type, source, userId, dateEvent, productId);
        kafkaTemplate.send(topic,event);
        Reponse rep=new Reponse();
        rep.setCode(100);
        rep.setMessage("Le message a été bien reçu");
        return rep ;
    }
}
