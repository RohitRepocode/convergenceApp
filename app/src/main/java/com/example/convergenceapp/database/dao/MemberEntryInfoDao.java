package com.example.convergenceapp.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface MemberEntryInfoDao {
    @Insert
    public void insert(MemberEntryInfoDao memberEntryInfoDao);

}
