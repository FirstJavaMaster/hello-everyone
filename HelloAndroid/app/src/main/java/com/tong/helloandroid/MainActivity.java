package com.tong.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import com.tong.helloandroid.adapter.UserAdapter;
import com.tong.helloandroid.config.AppDatabase;
import com.tong.helloandroid.entity.User;
import com.tong.helloandroid.viewmodule.UserViewModule;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author matrix
 * @date
 */
public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.tong.helloandroid.MESSAGE";

    private AppDatabase appDatabase;
    private UserViewModule userViewModule;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = AppDatabase.getInstance(getApplicationContext());
        userAdapter = new UserAdapter(new ArrayList<>(), getApplicationContext());

        ListView listView = findViewById(R.id.listview);
        listView.setEmptyView(findViewById(R.id.empty));
        listView.setAdapter(userAdapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
            toast.setText("你点击了第" + position + "项");
            toast.show();
        });
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
            toast.setText("你长按了第" + position + "项");
            toast.show();
            return true;
        });

        userViewModule = ViewModelProviders.of(this).get(UserViewModule.class);
        userViewModule.getUserList().observe(this, users -> userAdapter.updateUserList(users));
    }

    public void add(View view) {
        User user = new User(null, RandomStringUtils.randomAlphabetic(4), RandomStringUtils.randomAlphabetic(6));
        appDatabase.userDao().insertAll(user);
    }

    public void select(View view) {
        System.out.println(123);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


}