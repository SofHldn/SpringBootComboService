package se.iths.songspercountry.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import se.iths.songspercountry.entities.Combo;
import se.iths.songspercountry.entities.Country;
import se.iths.songspercountry.services.ComboService;

import java.util.List;

public class ComboController {

    //    @RequestMapping("/combo/")
//    public String findOne(){
//
//        String jsonObject = new String(
//                restTemplate.exchange("http://localhost:58081/countries", HttpMethod.GET, 	null, String.class).getBody());
//        return jsonObject;

        @RequestMapping(value="/combo/{cc}", method= RequestMethod.GET)
        @ResponseBody
        public Combo findOne(@PathVariable String cc){

        ResponseEntity<Country> responseEntity =
                new RestTemplate().getForEntity(
                        "http://localhost:58081/countries/", Country.class, cc);


        Combo combo = new Combo(responseEntity.getBody().getCountryCode(), responseEntity.getBody().getCountryName(), "hej", 1L);

        System.out.println(responseEntity.getBody().getCountryName());


        return combo;


    }


}
