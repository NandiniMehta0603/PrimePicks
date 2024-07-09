package com.movie.primepicks.entity;

import jakarta.persistence.*;

@Entity
@Table(name="preference")
public class Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;
    Integer action=0;
    Integer comedy=0;
    Integer horror=0;
    Integer thriller=0;
    Integer suspense=0;

    public Preference(){}

    public Preference(Integer action, Integer comedy, Integer horror, Integer thriller, Integer suspense){
        this.action = action;
        this.comedy = comedy;
        this.horror = horror;
        this.thriller = thriller;
        this.suspense = suspense;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public Integer getComedy() {
        return comedy;
    }

    public void setComedy(Integer comedy) {
        this.comedy = comedy;
    }

    public Integer getHorror() {
        return horror;
    }

    public void setHorror(Integer horror) {
        this.horror = horror;
    }

    public Integer getThriller() {
        return thriller;
    }

    public void setThriller(Integer thriller) {
        this.thriller = thriller;
    }

    public Integer getSuspense() {
        return suspense;
    }

    public void setSuspense(Integer suspense) {
        this.suspense = suspense;
    }

    @Override
    public String toString() {
        return "PreferenceDTO{" +
                "action=" + action +
                ", comedy=" + comedy +
                ", horror=" + horror +
                ", thriller=" + thriller +
                ", suspense=" + suspense +
                '}';
    }
}
