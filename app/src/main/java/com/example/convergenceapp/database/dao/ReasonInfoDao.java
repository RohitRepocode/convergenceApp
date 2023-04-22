package com.example.convergenceapp.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.convergenceapp.database.dbBean.MemberBean;
import com.example.convergenceapp.database.dbBean.ReasonBean;
import com.example.convergenceapp.database.entity.ReasonInfoEntity;

import java.util.List;
@Dao
public interface ReasonInfoDao {
    @Insert
    void insert(ReasonInfoEntity reasonInfoEntity);
@Query("select reason from ReasonInfoEntity")
List<ReasonBean> getReason();

}
