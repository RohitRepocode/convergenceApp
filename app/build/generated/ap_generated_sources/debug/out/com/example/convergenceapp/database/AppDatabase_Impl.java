package com.example.convergenceapp.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.convergenceapp.database.dao.LoginInfoDao;
import com.example.convergenceapp.database.dao.LoginInfoDao_Impl;
import com.example.convergenceapp.database.dao.MemberEntryInfoDao;
import com.example.convergenceapp.database.dao.MemberEntryInfoDao_Impl;
import com.example.convergenceapp.database.dao.NrlmInfoDao;
import com.example.convergenceapp.database.dao.NrlmInfoDao_Impl;
import com.example.convergenceapp.database.dao.PmaygInfoDao;
import com.example.convergenceapp.database.dao.PmaygInfoDao_Impl;
import com.example.convergenceapp.database.dao.ReasonInfoDao;
import com.example.convergenceapp.database.dao.ReasonInfoDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile LoginInfoDao _loginInfoDao;

  private volatile NrlmInfoDao _nrlmInfoDao;

  private volatile PmaygInfoDao _pmaygInfoDao;

  private volatile ReasonInfoDao _reasonInfoDao;

  private volatile MemberEntryInfoDao _memberEntryInfoDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(7) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `LoginInfoEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `login_id` TEXT, `password` TEXT, `mobile_number` TEXT, `state_code` TEXT, `state_short_name` TEXT, `server_date_time` TEXT, `language_id` TEXT, `login_attempt` TEXT, `logout_days` TEXT, `user_name` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `NrlmInfoEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `gp_code` TEXT, `lgd_gp_code` TEXT, `gp_name` TEXT, `village_code` TEXT, `village_name` TEXT, `shg_name` TEXT, `shg_code` TEXT, `member_name` TEXT, `member_code` TEXT, `user_id` TEXT, `block_name` TEXT, `lgd_state_code` TEXT, `state_name` TEXT, `state_code` TEXT, `block_code` TEXT, `district_name` TEXT, `lgd_district_code` TEXT, `lgd_block_code` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `PmaygInfoEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `gp_code` TEXT, `flag` TEXT, `gp_name` TEXT, `village_code` TEXT, `village_name` TEXT, `scheme` TEXT, `beneficiary_holder_name` TEXT, `beneficiary_id` TEXT, `ifsc_code` TEXT, `beneficiary_acc_no` TEXT, `beneficiary_bank_name` TEXT, `beneficiary_branch_name` TEXT, `mobile_no` TEXT, `member_name` TEXT, `holder_sync_flag` TEXT, `mothername` TEXT, `districtname` TEXT, `blockcode` TEXT, `districtcode` TEXT, `statecode` TEXT, `fathername` TEXT, `blockname` TEXT, `sl_no_member` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ReasonInfoEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `reason` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MemberEntryInfoEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `gp_Name` TEXT, `scheme_Name` TEXT, `ben_Id` TEXT, `lgd_GpCode` TEXT, `lgd_Villagecode` TEXT, `mobile_no` TEXT, `ben_availability` TEXT, `any_Familyinshg` TEXT, `willing_joinshg` TEXT, `reason` TEXT, `shg_Code` TEXT, `member_Code` TEXT, `village_Code` TEXT, `created_on` TEXT, `appVersion` TEXT, `syncFlag` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'fa21fde9e8503a08ddb3fb60268ad5db')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `LoginInfoEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `NrlmInfoEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `PmaygInfoEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `ReasonInfoEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `MemberEntryInfoEntity`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsLoginInfoEntity = new HashMap<String, TableInfo.Column>(11);
        _columnsLoginInfoEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoginInfoEntity.put("login_id", new TableInfo.Column("login_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoginInfoEntity.put("password", new TableInfo.Column("password", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoginInfoEntity.put("mobile_number", new TableInfo.Column("mobile_number", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoginInfoEntity.put("state_code", new TableInfo.Column("state_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoginInfoEntity.put("state_short_name", new TableInfo.Column("state_short_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoginInfoEntity.put("server_date_time", new TableInfo.Column("server_date_time", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoginInfoEntity.put("language_id", new TableInfo.Column("language_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoginInfoEntity.put("login_attempt", new TableInfo.Column("login_attempt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoginInfoEntity.put("logout_days", new TableInfo.Column("logout_days", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoginInfoEntity.put("user_name", new TableInfo.Column("user_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLoginInfoEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLoginInfoEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLoginInfoEntity = new TableInfo("LoginInfoEntity", _columnsLoginInfoEntity, _foreignKeysLoginInfoEntity, _indicesLoginInfoEntity);
        final TableInfo _existingLoginInfoEntity = TableInfo.read(_db, "LoginInfoEntity");
        if (! _infoLoginInfoEntity.equals(_existingLoginInfoEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "LoginInfoEntity(com.example.convergenceapp.database.entity.LoginInfoEntity).\n"
                  + " Expected:\n" + _infoLoginInfoEntity + "\n"
                  + " Found:\n" + _existingLoginInfoEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsNrlmInfoEntity = new HashMap<String, TableInfo.Column>(19);
        _columnsNrlmInfoEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNrlmInfoEntity.put("gp_code", new TableInfo.Column("gp_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNrlmInfoEntity.put("lgd_gp_code", new TableInfo.Column("lgd_gp_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNrlmInfoEntity.put("gp_name", new TableInfo.Column("gp_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNrlmInfoEntity.put("village_code", new TableInfo.Column("village_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNrlmInfoEntity.put("village_name", new TableInfo.Column("village_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNrlmInfoEntity.put("shg_name", new TableInfo.Column("shg_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNrlmInfoEntity.put("shg_code", new TableInfo.Column("shg_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNrlmInfoEntity.put("member_name", new TableInfo.Column("member_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNrlmInfoEntity.put("member_code", new TableInfo.Column("member_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNrlmInfoEntity.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNrlmInfoEntity.put("block_name", new TableInfo.Column("block_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNrlmInfoEntity.put("lgd_state_code", new TableInfo.Column("lgd_state_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNrlmInfoEntity.put("state_name", new TableInfo.Column("state_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNrlmInfoEntity.put("state_code", new TableInfo.Column("state_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNrlmInfoEntity.put("block_code", new TableInfo.Column("block_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNrlmInfoEntity.put("district_name", new TableInfo.Column("district_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNrlmInfoEntity.put("lgd_district_code", new TableInfo.Column("lgd_district_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNrlmInfoEntity.put("lgd_block_code", new TableInfo.Column("lgd_block_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNrlmInfoEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNrlmInfoEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNrlmInfoEntity = new TableInfo("NrlmInfoEntity", _columnsNrlmInfoEntity, _foreignKeysNrlmInfoEntity, _indicesNrlmInfoEntity);
        final TableInfo _existingNrlmInfoEntity = TableInfo.read(_db, "NrlmInfoEntity");
        if (! _infoNrlmInfoEntity.equals(_existingNrlmInfoEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "NrlmInfoEntity(com.example.convergenceapp.database.entity.NrlmInfoEntity).\n"
                  + " Expected:\n" + _infoNrlmInfoEntity + "\n"
                  + " Found:\n" + _existingNrlmInfoEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsPmaygInfoEntity = new HashMap<String, TableInfo.Column>(24);
        _columnsPmaygInfoEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("gp_code", new TableInfo.Column("gp_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("flag", new TableInfo.Column("flag", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("gp_name", new TableInfo.Column("gp_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("village_code", new TableInfo.Column("village_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("village_name", new TableInfo.Column("village_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("scheme", new TableInfo.Column("scheme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("beneficiary_holder_name", new TableInfo.Column("beneficiary_holder_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("beneficiary_id", new TableInfo.Column("beneficiary_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("ifsc_code", new TableInfo.Column("ifsc_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("beneficiary_acc_no", new TableInfo.Column("beneficiary_acc_no", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("beneficiary_bank_name", new TableInfo.Column("beneficiary_bank_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("beneficiary_branch_name", new TableInfo.Column("beneficiary_branch_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("mobile_no", new TableInfo.Column("mobile_no", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("member_name", new TableInfo.Column("member_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("holder_sync_flag", new TableInfo.Column("holder_sync_flag", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("mothername", new TableInfo.Column("mothername", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("districtname", new TableInfo.Column("districtname", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("blockcode", new TableInfo.Column("blockcode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("districtcode", new TableInfo.Column("districtcode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("statecode", new TableInfo.Column("statecode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("fathername", new TableInfo.Column("fathername", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("blockname", new TableInfo.Column("blockname", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPmaygInfoEntity.put("sl_no_member", new TableInfo.Column("sl_no_member", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPmaygInfoEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPmaygInfoEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPmaygInfoEntity = new TableInfo("PmaygInfoEntity", _columnsPmaygInfoEntity, _foreignKeysPmaygInfoEntity, _indicesPmaygInfoEntity);
        final TableInfo _existingPmaygInfoEntity = TableInfo.read(_db, "PmaygInfoEntity");
        if (! _infoPmaygInfoEntity.equals(_existingPmaygInfoEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "PmaygInfoEntity(com.example.convergenceapp.database.entity.PmaygInfoEntity).\n"
                  + " Expected:\n" + _infoPmaygInfoEntity + "\n"
                  + " Found:\n" + _existingPmaygInfoEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsReasonInfoEntity = new HashMap<String, TableInfo.Column>(2);
        _columnsReasonInfoEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReasonInfoEntity.put("reason", new TableInfo.Column("reason", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysReasonInfoEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesReasonInfoEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoReasonInfoEntity = new TableInfo("ReasonInfoEntity", _columnsReasonInfoEntity, _foreignKeysReasonInfoEntity, _indicesReasonInfoEntity);
        final TableInfo _existingReasonInfoEntity = TableInfo.read(_db, "ReasonInfoEntity");
        if (! _infoReasonInfoEntity.equals(_existingReasonInfoEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "ReasonInfoEntity(com.example.convergenceapp.database.entity.ReasonInfoEntity).\n"
                  + " Expected:\n" + _infoReasonInfoEntity + "\n"
                  + " Found:\n" + _existingReasonInfoEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsMemberEntryInfoEntity = new HashMap<String, TableInfo.Column>(17);
        _columnsMemberEntryInfoEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMemberEntryInfoEntity.put("gp_Name", new TableInfo.Column("gp_Name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMemberEntryInfoEntity.put("scheme_Name", new TableInfo.Column("scheme_Name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMemberEntryInfoEntity.put("ben_Id", new TableInfo.Column("ben_Id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMemberEntryInfoEntity.put("lgd_GpCode", new TableInfo.Column("lgd_GpCode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMemberEntryInfoEntity.put("lgd_Villagecode", new TableInfo.Column("lgd_Villagecode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMemberEntryInfoEntity.put("mobile_no", new TableInfo.Column("mobile_no", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMemberEntryInfoEntity.put("ben_availability", new TableInfo.Column("ben_availability", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMemberEntryInfoEntity.put("any_Familyinshg", new TableInfo.Column("any_Familyinshg", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMemberEntryInfoEntity.put("willing_joinshg", new TableInfo.Column("willing_joinshg", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMemberEntryInfoEntity.put("reason", new TableInfo.Column("reason", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMemberEntryInfoEntity.put("shg_Code", new TableInfo.Column("shg_Code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMemberEntryInfoEntity.put("member_Code", new TableInfo.Column("member_Code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMemberEntryInfoEntity.put("village_Code", new TableInfo.Column("village_Code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMemberEntryInfoEntity.put("created_on", new TableInfo.Column("created_on", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMemberEntryInfoEntity.put("appVersion", new TableInfo.Column("appVersion", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMemberEntryInfoEntity.put("syncFlag", new TableInfo.Column("syncFlag", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMemberEntryInfoEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMemberEntryInfoEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMemberEntryInfoEntity = new TableInfo("MemberEntryInfoEntity", _columnsMemberEntryInfoEntity, _foreignKeysMemberEntryInfoEntity, _indicesMemberEntryInfoEntity);
        final TableInfo _existingMemberEntryInfoEntity = TableInfo.read(_db, "MemberEntryInfoEntity");
        if (! _infoMemberEntryInfoEntity.equals(_existingMemberEntryInfoEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "MemberEntryInfoEntity(com.example.convergenceapp.database.entity.MemberEntryInfoEntity).\n"
                  + " Expected:\n" + _infoMemberEntryInfoEntity + "\n"
                  + " Found:\n" + _existingMemberEntryInfoEntity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "fa21fde9e8503a08ddb3fb60268ad5db", "4c151cf5c86aefeaa4572a7e18755979");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "LoginInfoEntity","NrlmInfoEntity","PmaygInfoEntity","ReasonInfoEntity","MemberEntryInfoEntity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `LoginInfoEntity`");
      _db.execSQL("DELETE FROM `NrlmInfoEntity`");
      _db.execSQL("DELETE FROM `PmaygInfoEntity`");
      _db.execSQL("DELETE FROM `ReasonInfoEntity`");
      _db.execSQL("DELETE FROM `MemberEntryInfoEntity`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(LoginInfoDao.class, LoginInfoDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(NrlmInfoDao.class, NrlmInfoDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PmaygInfoDao.class, PmaygInfoDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ReasonInfoDao.class, ReasonInfoDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MemberEntryInfoDao.class, MemberEntryInfoDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public LoginInfoDao loginInfoDao() {
    if (_loginInfoDao != null) {
      return _loginInfoDao;
    } else {
      synchronized(this) {
        if(_loginInfoDao == null) {
          _loginInfoDao = new LoginInfoDao_Impl(this);
        }
        return _loginInfoDao;
      }
    }
  }

  @Override
  public NrlmInfoDao nrlmInfoDao() {
    if (_nrlmInfoDao != null) {
      return _nrlmInfoDao;
    } else {
      synchronized(this) {
        if(_nrlmInfoDao == null) {
          _nrlmInfoDao = new NrlmInfoDao_Impl(this);
        }
        return _nrlmInfoDao;
      }
    }
  }

  @Override
  public PmaygInfoDao pmaygInfoDao() {
    if (_pmaygInfoDao != null) {
      return _pmaygInfoDao;
    } else {
      synchronized(this) {
        if(_pmaygInfoDao == null) {
          _pmaygInfoDao = new PmaygInfoDao_Impl(this);
        }
        return _pmaygInfoDao;
      }
    }
  }

  @Override
  public ReasonInfoDao reasonInfoDao() {
    if (_reasonInfoDao != null) {
      return _reasonInfoDao;
    } else {
      synchronized(this) {
        if(_reasonInfoDao == null) {
          _reasonInfoDao = new ReasonInfoDao_Impl(this);
        }
        return _reasonInfoDao;
      }
    }
  }

  @Override
  public MemberEntryInfoDao memberEntryInfoDao() {
    if (_memberEntryInfoDao != null) {
      return _memberEntryInfoDao;
    } else {
      synchronized(this) {
        if(_memberEntryInfoDao == null) {
          _memberEntryInfoDao = new MemberEntryInfoDao_Impl(this);
        }
        return _memberEntryInfoDao;
      }
    }
  }
}
