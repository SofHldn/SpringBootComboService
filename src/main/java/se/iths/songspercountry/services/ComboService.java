package se.iths.songspercountry.services;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import se.iths.songspercountry.entities.Combo;
import se.iths.songspercountry.repository.ComboRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComboService implements se.iths.songspercountry.services.Service {

    private ComboRepository comboRepository;

    public ComboService(ComboRepository comboRepository) {
        this.comboRepository = comboRepository;

    }


    @Override
    public Optional<Combo> getOne(String cc) {
        System.out.println("json");
        String url = "http://localhost:7070/countries/" + cc;


//        String url = "http://localhost:8500/v1/catalog/service/countries-service/countries/cc";
//        String url1 = "http://localhost:8500/v1/catalog/service/songs/songs/1";
        RestTemplate restTemplateCountry = new RestTemplate();
        Combo country = restTemplateCountry.getForObject(url, Combo.class);

        assert country != null;
        String url1 = "http://localhost:6060/songs/" + country.getSongId();
        RestTemplate restTemplateSong = new RestTemplate();
        Combo song = restTemplateSong.getForObject(url1, Combo.class);

        assert song != null;
        Combo combo = new Combo(country.getCountryCode(), country.getCountryName(), song.getTitle(),  country.getSongId());


        System.out.println(country);
        System.out.println(song);
        System.out.println(combo);
        return Optional.of(combo);


    }

    @Override
    public Combo createCombo(Combo combo) {
        if (combo.getCountryName().isEmpty())
            throw new RuntimeException();

        return comboRepository.save(combo);

    }
    @Override
    public List<Combo> listAllCombos() {

        String urlCountry = "http://localhost:7070/countries/";
        String urlSong = "http://localhost:6060/songs/";
        RestTemplate restTemplateCountry = new RestTemplate();
        ResponseEntity<Combo[]> response = restTemplateCountry.getForEntity(urlCountry, Combo[].class);
        Combo[] country = response.getBody();


        List <Combo> list = new ArrayList<>();
        for (Combo c: country) {

            RestTemplate restTemplateSong = new RestTemplate();
            Combo song = restTemplateSong.getForObject(urlSong+c.getSongId(), Combo.class);
            Combo combo = new Combo(c.getCountryCode(), c.getCountryName(), song.getTitle(), c.getSongId());

            list.add(combo);

        }

        return list;

    }

}
