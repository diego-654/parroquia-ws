package com.parroquias.parroquia_ws.parroquia_ws.baptism.entities;

import java.time.LocalDate;

import com.parroquias.parroquia_ws.parroquia_ws.person.entities.Person;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "baptisms")
public class Baptism {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer fojas;
    private Integer number;
    private LocalDate date;
    private String parish;
    private String officiant;
    private String annotations;
    private Long count;

    @ManyToOne
    @JoinColumn(name = "idperson_baptized")
    private Person baptizedPerson;

    @ManyToOne
    @JoinColumn(name = "idperson_father")
    private Person father;

    @ManyToOne
    @JoinColumn(name = "idperson_mother")
    private Person mother;

    @ManyToOne
    @JoinColumn(name = "idperson_godfather")
    private Person godfather;

    @ManyToOne
    @JoinColumn(name = "idperson_godmother")
    private Person godmother;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFojas() {
        return fojas;
    }

    public void setFojas(Integer fojas) {
        this.fojas = fojas;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getParish() {
        return parish;
    }

    public void setParish(String parish) {
        this.parish = parish;
    }

    public String getOfficiant() {
        return officiant;
    }

    public void setOfficiant(String officiant) {
        this.officiant = officiant;
    }

    public String getAnnotations() {
        return annotations;
    }

    public void setAnnotations(String annotations) {
        this.annotations = annotations;
    }

    public Person getBaptizedPerson() {
        return baptizedPerson;
    }

    public void setBaptizedPerson(Person baptizedPerson) {
        this.baptizedPerson = baptizedPerson;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getGodfather() {
        return godfather;
    }

    public void setGodfather(Person godfather) {
        this.godfather = godfather;
    }

    public Person getGodmother() {
        return godmother;
    }

    public void setGodmother(Person godmother) {
        this.godmother = godmother;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}
