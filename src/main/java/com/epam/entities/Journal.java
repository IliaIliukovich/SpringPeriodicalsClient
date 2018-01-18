package com.epam.entities;

import java.math.BigDecimal;

public class Journal {

    private Long id_journal;

    private String name;

    private String description;

    private BigDecimal price;

    private State state = State.UNSUBSCRIBED;

    private long relationalTableId;

    public Journal() {
    }

    public Journal(Long id_journal, String name, String description, BigDecimal price) {
        this.id_journal = id_journal;
        this.name = name;
        this.description = description;
        this.price = price;
    }


    public Long getId_journal() {
        return id_journal;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId_journal(Long id_journal) {
        this.id_journal = id_journal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public long getRelationalTableId() {
        return relationalTableId;
    }

    public void setRelationalTableId(long relationalTableId) {
        this.relationalTableId = relationalTableId;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id_journal=" + id_journal +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", state=" + state +
                ", relationalTableId=" + relationalTableId +
                '}';
    }

    public enum State {
        SUBSCRIBED,
        UNSUBSCRIBED,
        CHOSEN,
    }
}
