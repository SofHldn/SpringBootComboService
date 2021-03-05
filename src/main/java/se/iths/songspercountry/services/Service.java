package se.iths.songspercountry.services;

import se.iths.songspercountry.entities.Combo;

import java.util.List;
import java.util.Optional;

public interface Service {

    List<Combo> listAllCombos();

    Optional<Combo> getOne(String countryCode);

    Combo createCombo(Combo combo);

}
