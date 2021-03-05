package se.iths.songspercountry.services;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import se.iths.songspercountry.entities.Combo;
import se.iths.songspercountry.entities.Country;
import se.iths.songspercountry.repository.ComboRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ComboService implements se.iths.songspercountry.services.Service {

    private ComboRepository comboRepository;

    public ComboService(ComboRepository comboRepository) {
        this.comboRepository = comboRepository;

    }

    @Override
    public List<Combo> listAllCombos() {
        return comboRepository.findAll();
    }

    @Override
    public Optional<Combo> getOne(String countryCode) {
        return comboRepository.findById(countryCode);
    }

    @Override
    public Combo createCombo(Combo combo) {

        if (combo.getCountryName().isEmpty())
            throw new RuntimeException();

        return comboRepository.save(combo);
    }


    public Combo getCountries() {
        System.out.println("json");
        String url = "http://client-service/countries/cc";
        String url1 = "http://client-service/songs/1";
        RestTemplate restTemplateCountry = new RestTemplate();
        Combo country = restTemplateCountry.getForObject(url, Combo.class);

        RestTemplate restTemplateSong = new RestTemplate();
        Combo song = restTemplateSong.getForObject(url1, Combo.class);

        Combo combo = new Combo(country.getCountryCode(), country.getCountryName(), song.getTitle(),  country.getSongId());


        System.out.println(country);
        System.out.println(song);
        System.out.println(combo);
        return combo;


    }

}
