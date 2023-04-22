package com.example.convergenceapp.database.dbBean;

import androidx.room.ColumnInfo;

public class MemberBean {
    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public MemberBean(String memberCode, String memberName) {
        this.memberCode = memberCode;
        this.memberName = memberName;
    }

    @ColumnInfo(name = "member_code")
    private String memberCode;
    @ColumnInfo(name = "member_name")
    private String memberName;
}
