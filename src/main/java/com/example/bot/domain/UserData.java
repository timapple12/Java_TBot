package com.example.bot.domain;

import com.example.bot.states.States;
import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@AllArgsConstructor
public class UserData {
    @Id
    private Long id;

    private String message;
    private States states;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public States getStates() {
        return states;
    }

    public void setStates(States states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", states=" + states +
                '}';
    }
}
