package se.iths.songspercountry.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.iths.songspercountry.entities.Combo;

@Repository
public interface ComboRepository extends JpaRepository <Combo, String> {

}
