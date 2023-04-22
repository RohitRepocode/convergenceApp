package com.example.convergenceapp.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.convergenceapp.database.dbBean.MemberBean;
import com.example.convergenceapp.database.dbBean.NrlmDataBean;
import com.example.convergenceapp.database.dbBean.NrlmVillageBean;
import com.example.convergenceapp.database.dbBean.ShgBean;
import com.example.convergenceapp.database.entity.NrlmInfoEntity;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NrlmInfoDao_Impl implements NrlmInfoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<NrlmInfoEntity> __insertionAdapterOfNrlmInfoEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public NrlmInfoDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNrlmInfoEntity = new EntityInsertionAdapter<NrlmInfoEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `NrlmInfoEntity` (`id`,`gp_code`,`lgd_gp_code`,`gp_name`,`village_code`,`village_name`,`shg_name`,`shg_code`,`member_name`,`member_code`,`user_id`,`block_name`,`lgd_state_code`,`state_name`,`state_code`,`block_code`,`district_name`,`lgd_district_code`,`lgd_block_code`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NrlmInfoEntity value) {
        stmt.bindLong(1, value.id);
        if (value.getGp_code() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGp_code());
        }
        if (value.getLgd_gp_code() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLgd_gp_code());
        }
        if (value.getGp_name() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGp_name());
        }
        if (value.getVillage_code() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getVillage_code());
        }
        if (value.getVillage_name() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getVillage_name());
        }
        if (value.getShg_name() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getShg_name());
        }
        if (value.getShg_code() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getShg_code());
        }
        if (value.getMember_name() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getMember_name());
        }
        if (value.getMember_code() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getMember_code());
        }
        if (value.getUser_id() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getUser_id());
        }
        if (value.getBlock_name() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getBlock_name());
        }
        if (value.getLgd_state_code() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getLgd_state_code());
        }
        if (value.getState_name() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getState_name());
        }
        if (value.getState_code() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getState_code());
        }
        if (value.getBlock_code() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getBlock_code());
        }
        if (value.getDistrict_name() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getDistrict_name());
        }
        if (value.getLgd_district_code() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getLgd_district_code());
        }
        if (value.getLgd_block_code() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getLgd_block_code());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from NrlmInfoEntity";
        return _query;
      }
    };
  }

  @Override
  public void insert(final NrlmInfoEntity nrlmInfoEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfNrlmInfoEntity.insert(nrlmInfoEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<NrlmDataBean> getNrlmList() {
    final String _sql = "select distinct gp_name,gp_code from NrlmInfoEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfGpName = 0;
      final int _cursorIndexOfGpCode = 1;
      final List<NrlmDataBean> _result = new ArrayList<NrlmDataBean>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final NrlmDataBean _item;
        _item = new NrlmDataBean();
        final String _tmpGpName;
        if (_cursor.isNull(_cursorIndexOfGpName)) {
          _tmpGpName = null;
        } else {
          _tmpGpName = _cursor.getString(_cursorIndexOfGpName);
        }
        _item.setGpName(_tmpGpName);
        final String _tmpGpCode;
        if (_cursor.isNull(_cursorIndexOfGpCode)) {
          _tmpGpCode = null;
        } else {
          _tmpGpCode = _cursor.getString(_cursorIndexOfGpCode);
        }
        _item.setGpCode(_tmpGpCode);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<NrlmVillageBean> getNrlmVillage(final String gpCode) {
    final String _sql = "select distinct village_name,village_code from NrlmInfoEntity where NrlmInfoEntity.gp_code =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (gpCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, gpCode);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfNrlmVillageName = 0;
      final int _cursorIndexOfNrlmVillageCode = 1;
      final List<NrlmVillageBean> _result = new ArrayList<NrlmVillageBean>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final NrlmVillageBean _item;
        final String _tmpNrlmVillageName;
        if (_cursor.isNull(_cursorIndexOfNrlmVillageName)) {
          _tmpNrlmVillageName = null;
        } else {
          _tmpNrlmVillageName = _cursor.getString(_cursorIndexOfNrlmVillageName);
        }
        final String _tmpNrlmVillageCode;
        if (_cursor.isNull(_cursorIndexOfNrlmVillageCode)) {
          _tmpNrlmVillageCode = null;
        } else {
          _tmpNrlmVillageCode = _cursor.getString(_cursorIndexOfNrlmVillageCode);
        }
        _item = new NrlmVillageBean(_tmpNrlmVillageCode,_tmpNrlmVillageName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ShgBean> getShg(final String villageCode) {
    final String _sql = "select distinct shg_name,shg_code from NrlmInfoEntity where NrlmInfoEntity.village_name =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (villageCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, villageCode);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfShgName = 0;
      final int _cursorIndexOfShgCode = 1;
      final List<ShgBean> _result = new ArrayList<ShgBean>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ShgBean _item;
        final String _tmpShgName;
        if (_cursor.isNull(_cursorIndexOfShgName)) {
          _tmpShgName = null;
        } else {
          _tmpShgName = _cursor.getString(_cursorIndexOfShgName);
        }
        final String _tmpShgCode;
        if (_cursor.isNull(_cursorIndexOfShgCode)) {
          _tmpShgCode = null;
        } else {
          _tmpShgCode = _cursor.getString(_cursorIndexOfShgCode);
        }
        _item = new ShgBean(_tmpShgCode,_tmpShgName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MemberBean> getMember(final String shgCode) {
    final String _sql = "select distinct member_code,member_name from NrlmInfoEntity where NrlmInfoEntity.shg_code =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (shgCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, shgCode);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMemberCode = 0;
      final int _cursorIndexOfMemberName = 1;
      final List<MemberBean> _result = new ArrayList<MemberBean>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MemberBean _item;
        final String _tmpMemberCode;
        if (_cursor.isNull(_cursorIndexOfMemberCode)) {
          _tmpMemberCode = null;
        } else {
          _tmpMemberCode = _cursor.getString(_cursorIndexOfMemberCode);
        }
        final String _tmpMemberName;
        if (_cursor.isNull(_cursorIndexOfMemberName)) {
          _tmpMemberName = null;
        } else {
          _tmpMemberName = _cursor.getString(_cursorIndexOfMemberName);
        }
        _item = new MemberBean(_tmpMemberCode,_tmpMemberName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
