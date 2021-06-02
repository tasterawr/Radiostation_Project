package org.example.DAL.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RadioDj extends Employee{
    private String djNickname;

    public RadioDj() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDjNickname() {
        return djNickname;
    }

    public void setDjNickname(String djNickname) {
        this.djNickname = djNickname;
    }
}
