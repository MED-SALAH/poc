package com.presentation.demo.Controller;


import com.presentation.demo.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalyticsController {

    private final String topic = "eventUser";

    @Autowired
    private KafkaTemplate <String, Event> kafkaTemplate;

    @GetMapping("/analytics")
    @ResponseBody
    public Event productDetail( @RequestParam(required = true) String type,
                                @RequestParam(required = true) String source,
                                @RequestParam(required = true) String userId,
                                @RequestParam(required = true) String dateEvent,
                                @RequestParam(required = false) String productId){

        Event event = new Event(type, source, userId, dateEvent, productId);
        kafkaTemplate.send(topic,event);
        return event;
    }
}
