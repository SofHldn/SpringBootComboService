package se.iths.songspercountry.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.iths.songspercountry.entities.Combo;
import se.iths.songspercountry.services.ComboService;

import java.util.List;
import java.util.Optional;

@RestController
public class ComboController {

        @Autowired
        private ComboService service;



//        public ComboController(Service service) {
//                this.service = service;
//        }
    //    @RequestMapping("/combo/")
//    public String findOne(){
//
//        String jsonObject = new String(
//                restTemplate.exchange("http://localhost:58081/countries", HttpMethod.GET, 	null, String.class).getBody());
//        return jsonObject;

        @GetMapping("/combo")
        public List<Combo> listAll(){

                Combo combo = new Combo("se", "sve", "hej", 1L);
                service.createCombo(combo);
                return service.listAllCombos();

        }

        @GetMapping("/combo/cc")
        public Combo one(){
                //var resultSongs = service.getSongs();


                var resultCountries= service.getCountries();
//                resultContries.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
//                        "id " + " Not Found Contries"));
//                var result = resultSongs.toString() + resultContries.toString();
//                System.out.println(result);
                return resultCountries;


        }




//        @GetMapping("/combo/{cc}")
//        public Combo findOne(@PathVariable String cc){
//
//        ResponseEntity<Country> responseEntity =
//                new RestTemplate().getForEntity(
//                        "http://localhost:52356/countries/", Country.class, cc);
//
//
//        Combo combo = new Combo(responseEntity.getBody().getCountryCode(), responseEntity.getBody().getCountryName(), "hej", 1L);
//                service.createCombo(combo);
//        return service.getOne(cc)
//                        .orElseThrow(()-> getStatusException(cc));
//
//
//    }
        private ResponseStatusException getStatusException(String cc) {

                return new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Country code " + cc + " not found.");
        }


}
