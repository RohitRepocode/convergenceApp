package com.example.convergenceapp.database.dbBean;

import androidx.room.ColumnInfo;

public class ReasonBean {
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ReasonBean(String reason) {
        this.reason = reason;
    }

    @ColumnInfo(name = "reason")
    private String reason;
}
