package com.tong.helloandroid.viewmodule;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.tong.helloandroid.config.AppDatabase;
import com.tong.helloandroid.entity.User;

import java.util.List;

/**
 * @author tongpc32380
 * @date 2021/2/8 9:02
 */
public class UserViewModule extends AndroidViewModel {
    private AppDatabase appDatabase;
    private LiveData<List<User>> userList;

    public UserViewModule(@NonNull Application application) {
        super(application);
        appDatabase = AppDatabase.getInstance(application);
        userList = appDatabase.userDao().getAll();
    }

    public LiveData<List<User>> getUserList() {
        return userList;
    }


}
