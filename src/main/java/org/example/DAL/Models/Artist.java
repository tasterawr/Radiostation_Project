package org.example.DAL.Models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String artistName;

    private Date careerBeginDate;

    private Integer rating;

    public Artist() {

    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Date getCareerBeginDate() {
        return careerBeginDate;
    }

    public void setCareerBeginDate(Date careerBeginDate) {
        this.careerBeginDate = careerBeginDate;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
