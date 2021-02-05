package com.tong.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.tong.helloandroid.config.AppDatabase;
import com.tong.helloandroid.entity.User;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author matrix
 * @date
 */
public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.tong.helloandroid.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void insert(View view) {
        User user = new User();
        user.setFirstName(RandomStringUtils.randomAlphabetic(4));
        user.setLastName(RandomStringUtils.randomAlphabetic(6));

        AppDatabase appDatabase = AppDatabase.getInstance(MainActivity.this);
        appDatabase.userDao().insertAll(user);
        System.out.println(user);
    }

    public void select(View view) {

    }
}