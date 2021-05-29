package org.example.DAL.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Label {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String labelName;

    private Date labelCreationDate;

    public Label() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Date getLabelCreationDate() {
        return labelCreationDate;
    }

    public void setLabelCreationDate(Date labelCreationDate) {
        this.labelCreationDate = labelCreationDate;
    }
}
