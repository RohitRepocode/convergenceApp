package com.example.convergenceapp.database.dbBean;

import androidx.room.ColumnInfo;

public class GpBean {
    @ColumnInfo(name = "gp_code")
    private String gpCode;
    @ColumnInfo(name = "gp_name")
    private String gpName;

    public String getGpCode() {
        return gpCode;
    }

    public void setGpCode(String gpCode) {
        this.gpCode = gpCode;
    }

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }
}
