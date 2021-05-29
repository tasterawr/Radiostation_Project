package org.example.DAL.Models;

import javax.persistence.*;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long genreCode;

    private String genreName;

    private String description;

    public Genre() {

    }

    public Long getGenreCode() {
        return genreCode;
    }

    public void setGenreCode(Long genreCode) {
        this.genreCode = genreCode;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
