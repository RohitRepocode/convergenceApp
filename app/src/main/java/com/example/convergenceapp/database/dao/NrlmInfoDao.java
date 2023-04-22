package com.example.convergenceapp.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.convergenceapp.database.dbBean.BeneficiaryBean;
import com.example.convergenceapp.database.dbBean.MemberBean;
import com.example.convergenceapp.database.dbBean.NrlmDataBean;
import com.example.convergenceapp.database.dbBean.NrlmVillageBean;
import com.example.convergenceapp.database.dbBean.ShgBean;
import com.example.convergenceapp.database.entity.NrlmInfoEntity;

import java.util.List;

@Dao
public interface NrlmInfoDao {
    @Insert
    void insert(NrlmInfoEntity nrlmInfoEntity);

    @Query("select distinct gp_name,gp_code from NrlmInfoEntity")
    List<NrlmDataBean> getNrlmList();

    @Query("select distinct village_name,village_code from NrlmInfoEntity where NrlmInfoEntity.gp_code =:gpCode")
    List<NrlmVillageBean> getNrlmVillage(String gpCode);


    @Query("select distinct shg_name,shg_code from NrlmInfoEntity where NrlmInfoEntity.village_name =:villageCode")
    List<ShgBean> getShg(String villageCode);

    @Query("select distinct member_code,member_name from NrlmInfoEntity where NrlmInfoEntity.shg_code =:shgCode")
    List<MemberBean> getMember(String shgCode);

    @Query("delete from NrlmInfoEntity")
    void deleteAll();


}
