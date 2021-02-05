package com.tong.helloandroid.config;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.tong.helloandroid.dao.UserDao;
import com.tong.helloandroid.entity.User;

/**
 * @author tongpc32380
 * @date 2021/2/5 13:27
 */
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DEFAULT_DB_FILE_NAME = "default.db";
    private static volatile AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DEFAULT_DB_FILE_NAME)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }

    public abstract UserDao userDao();


}
