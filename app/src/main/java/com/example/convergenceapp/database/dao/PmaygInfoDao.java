package com.example.convergenceapp.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.convergenceapp.database.dbBean.BeneficiaryBean;
import com.example.convergenceapp.database.dbBean.GpBean;
import com.example.convergenceapp.database.dbBean.VillageBean;
import com.example.convergenceapp.database.entity.PmaygInfoEntity;

import java.util.List;

@Dao
public interface PmaygInfoDao {
    @Insert
    void insert(PmaygInfoEntity pmaygInfoEntity);

    @Query("delete from PmaygInfoEntity")
    void deleteAll();


    @Query("select distinct gp_code,gp_name from PmaygInfoEntity")
     List<GpBean> getGPList();
    @Query("select distinct village_code,village_name from PmaygInfoEntity where gp_name=:gpName")
    List<VillageBean> getVillageList(String gpName);
    @Query("select distinct fathername,mothername,beneficiary_id,beneficiary_holder_name,beneficiary_acc_no,beneficiary_bank_name,beneficiary_branch_name,mobile_no,ifsc_code from PmaygInfoEntity where village_name=:villageCode")
    List<BeneficiaryBean> getBenDetailsList(String villageCode);

}
