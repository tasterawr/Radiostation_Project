package org.example.DAL.Models;

import javax.persistence.*;

@Entity
public class RadioDj extends Employee{
    private String djNickname;

    @OneToOne(cascade = CascadeType.ALL)
    private RadioProgram program;

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

    public RadioProgram getProgram() {
        return program;
    }

    public void setProgram(RadioProgram program) {
        this.program = program;
    }
}
