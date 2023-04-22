package com.example.convergenceapp.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class NrlmInfoEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;
    private String gp_code, lgd_gp_code, gp_name, village_code, village_name, shg_name, shg_code, member_name, member_code, user_id, block_name, lgd_state_code, state_name, state_code, block_code, district_name, lgd_district_code, lgd_block_code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGp_code() {
        return gp_code;
    }

    public void setGp_code(String gp_code) {
        this.gp_code = gp_code;
    }

    public String getLgd_gp_code() {
        return lgd_gp_code;
    }

    public void setLgd_gp_code(String lgd_gp_code) {
        this.lgd_gp_code = lgd_gp_code;
    }

    public String getGp_name() {
        return gp_name;
    }

    public void setGp_name(String gp_name) {
        this.gp_name = gp_name;
    }

    public String getVillage_code() {
        return village_code;
    }

    public void setVillage_code(String village_code) {
        this.village_code = village_code;
    }

    public String getVillage_name() {
        return village_name;
    }

    public void setVillage_name(String village_name) {
        this.village_name = village_name;
    }

    public String getShg_name() {
        return shg_name;
    }

    public void setShg_name(String shg_name) {
        this.shg_name = shg_name;
    }

    public String getShg_code() {
        return shg_code;
    }

    public void setShg_code(String shg_code) {
        this.shg_code = shg_code;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_code() {
        return member_code;
    }

    public void setMember_code(String member_code) {
        this.member_code = member_code;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getBlock_name() {
        return block_name;
    }

    public void setBlock_name(String block_name) {
        this.block_name = block_name;
    }

    public String getLgd_state_code() {
        return lgd_state_code;
    }

    public void setLgd_state_code(String lgd_state_code) {
        this.lgd_state_code = lgd_state_code;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getBlock_code() {
        return block_code;
    }

    public void setBlock_code(String block_code) {
        this.block_code = block_code;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public String getLgd_district_code() {
        return lgd_district_code;
    }

    public void setLgd_district_code(String lgd_district_code) {
        this.lgd_district_code = lgd_district_code;
    }

    public String getLgd_block_code() {
        return lgd_block_code;
    }

    public void setLgd_block_code(String lgd_block_code) {
        this.lgd_block_code = lgd_block_code;
    }

    public NrlmInfoEntity(String gp_code, String lgd_gp_code, String gp_name, String village_code, String village_name, String shg_name, String shg_code, String member_name, String member_code, String user_id, String block_name, String lgd_state_code, String state_name, String state_code, String block_code, String district_name, String lgd_district_code, String lgd_block_code) {
        this.id = id;
        this.gp_code = gp_code;
        this.lgd_gp_code = lgd_gp_code;
        this.gp_name = gp_name;
        this.village_code = village_code;
        this.village_name = village_name;
        this.shg_name = shg_name;
        this.shg_code = shg_code;
        this.member_name = member_name;
        this.member_code = member_code;
        this.user_id = user_id;
        this.block_name = block_name;
        this.lgd_state_code = lgd_state_code;
        this.state_name = state_name;
        this.state_code = state_code;
        this.block_code = block_code;
        this.district_name = district_name;
        this.lgd_district_code = lgd_district_code;
        this.lgd_block_code = lgd_block_code;
    }
}