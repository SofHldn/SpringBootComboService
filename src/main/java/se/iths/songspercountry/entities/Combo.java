package se.iths.songspercountry.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Combo")
public class Combo {

    @Id
    private String countryCode;
    private String countryName;
    private String title;
    private Long songId;


    public Combo() {
    }

    public Combo(String countryCode, String countryName, String title, Long songId) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    @Override
    public String toString() {
        return "Combo{" +
                "countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", songName='" + title + '\'' +
                ", songId=" + songId +
                '}';
    }
}
