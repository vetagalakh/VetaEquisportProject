package com.vetaequesport.vetaequesportproject.entity;

import javax.persistence.Entity;
import java.util.Objects;
public class ApplicationForm {
    private String nameParticipant;
    private String horseName;
    private String rang;
    private String yearOfBirth;

    public ApplicationForm(String nameParticipant, String horseName, String rang, String yearOfBirth) {
        this.nameParticipant = nameParticipant;
        this.horseName = horseName;
        this.rang = rang;
        this.yearOfBirth = yearOfBirth;
    }
    public ApplicationForm() {

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationForm that = (ApplicationForm) o;
        return Objects.equals(nameParticipant, that.nameParticipant) && Objects.equals(horseName, that.horseName) && Objects.equals(rang, that.rang) && Objects.equals(yearOfBirth, that.yearOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameParticipant, horseName, rang, yearOfBirth);
    }

    @Override
    public String toString() {
        return "ApplicationForm{" +
                "nameParticipant='" + nameParticipant + '\'' +
                ", horseName='" + horseName + '\'' +
                ", rang='" + rang + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                '}';
    }
}
