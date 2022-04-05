package com.springpractice.roulette.rouletteapispring.model;

import javax.persistence.*;

@Entity
@Table(name = "roulettes")
public class Roulette {

    @Id
    @Column(name = "id", unique = true,nullable = false)
    @GeneratedValue()
    private int id;
    @Column(name = "state")
    private boolean isOpen;//1 - opened & 2 - closed

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        this.isOpen = open;
    }

    @Override
    public String toString() {
        return "Roulette{" +
                "id=" + id +
                ", stateOpen=" + isOpen +
                '}';
    }
}
