package com.vetaequesport.vetaequesportproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Rout {
    @Id
    @Column(name = "id_rout")
    private int idRout;
    @Column(name = "name_rout")
    private String nameRout;
    @Column(name = "desc_rout")
    private String descRout;

    public Rout(int idRout, String nameRout, String descRout) {
        this.idRout = idRout;
        this.nameRout = nameRout;
        this.descRout = descRout;
    }

    public Rout() {

    }

    public int getIdRout() {
        return idRout;
    }

    public void setIdRout(int idRout) {
        this.idRout = idRout;
    }

    public String getNameRout() {
        return nameRout;
    }

    public void setNameRout(String nameRout) {
        this.nameRout = nameRout;
    }

    public String getDescRout() {
        return descRout;
    }

    public void setDescRout(String descRout) {
        this.descRout = descRout;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rout rout = (Rout) o;
        return idRout == rout.idRout && Objects.equals(nameRout, rout.nameRout) && Objects.equals(descRout, rout.descRout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRout, nameRout, descRout);
    }

    @Override
    public String toString() {
        return "Rout{" +
                "idRout=" + idRout +
                ", nameRout='" + nameRout + '\'' +
                ", descRout='" + descRout + '\'' +
                '}';
    }

}
