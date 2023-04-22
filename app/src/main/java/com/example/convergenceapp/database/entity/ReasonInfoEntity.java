package com.example.convergenceapp.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class ReasonInfoEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    private String reason;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ReasonInfoEntity( String reason) {

        this.reason = reason;
    }
}
