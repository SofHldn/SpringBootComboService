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


        @GetMapping("/combo")
        public List<Combo> listAll(){

               return service.listAllCombos();

        }

        @GetMapping("/combo/{cc}")
        public Combo one(@PathVariable String cc){

                return service.getOne(cc).orElseThrow(()-> getStatusException(cc));

       }


        private ResponseStatusException getStatusException(String cc) {

                return new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Country code " + cc + " not found.");
        }


}
