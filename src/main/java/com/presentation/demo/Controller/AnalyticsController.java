package com.presentation.demo.Controller;


import com.presentation.demo.Response;
import com.presentation.demo.model.Description;
import com.presentation.demo.model.Event;
import com.presentation.demo.model.Product;
import org.apache.avro.data.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class AnalyticsController {

    private final String topic = "events";
    private List<Product> l = new ArrayList<Product>();

    @Autowired
    private KafkaTemplate <String, Event> kafkaTemplate;

    @GetMapping("/api/analytics")
    @ResponseBody
    public Response productDetail(@RequestParam(required = true) String type,
                                  @RequestParam(required = true) String source,
                                  @RequestParam(required = true) String userId,
                                  @RequestParam(required = true) String dateEvent,
                                  @RequestParam(required = false) String productId){

        Event event = new Event(type, source, userId, dateEvent, productId);
        //kafkaTemplate.send(topic,event);
        Response rep=new Response();
        rep.setCode(100);
        rep.setMessage("Le message a été bien reçu");
        return rep ;
    }
    @GetMapping("/api/")
    @ResponseBody
    public List<Product> listProduct(){
        //kafkaTemplate.send(topic,event);
        Description d1 = new Description("1200","2019","2");

        l.add(new Product("123","samsung","https://csmobiles.com/15739-large_default/samsung-galaxy-s10-g973f-512go-dual-sim-bleu.jpg",d1));

        l.add(new Product("124","iphone","https://static.fnac-static.com/multimedia/Images/FR/MDM/5f/b2/bd/12431967/1540-1/tsp20190913170846/Apple-iPhone-11-128-Go-6-1-Mauve.jpg",d1));

        l.add(new Product("123","samsung","https://csmobiles.com/15739-large_default/samsung-galaxy-s10-g973f-512go-dual-sim-bleu.jpg",d1));

        return l;
    }
    @RequestMapping(value = "/api/product", method = RequestMethod.POST)
    public String newEmployee(@RequestBody String newProduct) {
        System.out.println(Json.parseJson(newProduct));
        return newProduct;
    }


}
