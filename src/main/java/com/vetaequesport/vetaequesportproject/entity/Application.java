package com.vetaequesport.vetaequesportproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Application {
    @Id
    private int id;
    @Column(name = "name_participant")
    private String nameParticipant;
    @Column(name = "horse_name")
    private String horseName;
    @Column(name = "rang")
    private String rang;
    @Column(name = "year_of_birth")
    private String yearOfBirth;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return id == that.id && Objects.equals(nameParticipant, that.nameParticipant) && Objects.equals(horseName, that.horseName) && Objects.equals(rang, that.rang) && Objects.equals(yearOfBirth, that.yearOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameParticipant, horseName, rang, yearOfBirth);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameParticipant() {
        return nameParticipant;
    }

    public void setNameParticipant(String nameParticipant) {
        this.nameParticipant = nameParticipant;
    }

    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", nameParticipant='" + nameParticipant + '\'' +
                ", horseName='" + horseName + '\'' +
                ", rang='" + rang + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                '}';
    }
}
