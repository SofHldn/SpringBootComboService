package se.iths.songspercountry.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Combo")
public class Combo {

    @Id
    private String countryCode;
    private String countryName;
    private String songName;
    private Long songId;


    public Combo() {
    }

    public Combo(String countryCode, String countryName, String songName, Long songId) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.songName = songName;
        this.songId = songId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }
}
