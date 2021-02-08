package com.tong.helloandroid.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.tong.helloandroid.entity.User;

import java.util.List;

/**
 * @author tongpc32380
 * @date 2021/2/5 13:24
 */
@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    LiveData<List<User>> getAll();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
