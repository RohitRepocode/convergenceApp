package com.example.convergenceapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.convergenceapp.database.dao.LoginInfoDao;
import com.example.convergenceapp.database.dao.MemberEntryInfoDao;
import com.example.convergenceapp.database.dao.NrlmInfoDao;
import com.example.convergenceapp.database.dao.PmaygInfoDao;
import com.example.convergenceapp.database.dao.ReasonInfoDao;
import com.example.convergenceapp.database.entity.LoginInfoEntity;
import com.example.convergenceapp.database.entity.MemberEntryInfoEntity;
import com.example.convergenceapp.database.entity.NrlmInfoEntity;
import com.example.convergenceapp.database.entity.PmaygInfoEntity;
import com.example.convergenceapp.database.entity.ReasonInfoEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {LoginInfoEntity.class, NrlmInfoEntity.class, PmaygInfoEntity.class, ReasonInfoEntity.class, MemberEntryInfoEntity.class}
        , version = 7, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "convergence.db";
    public static volatile AppDatabase instance;
    private static final int NUMBER_OF_THREADS = 5;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public abstract LoginInfoDao loginInfoDao();
    public abstract NrlmInfoDao nrlmInfoDao();
    public abstract PmaygInfoDao pmaygInfoDao();
    public abstract ReasonInfoDao reasonInfoDao();

    public abstract MemberEntryInfoDao memberEntryInfoDao();


    public static AppDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, DATABASE_NAME).fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }


}
