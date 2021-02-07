package com.tong.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tong.helloandroid.config.AppDatabase;
import com.tong.helloandroid.entity.User;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.util.LinkedList;

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

        LinkedList<YetLanguage> mData = new LinkedList<>();
        mData.add(new YetLanguage("Kotlin", "Kotlin 是运行在 Java 虚拟机上的静态语言，被称之为 Android 世界的 Swift", R.drawable.images));
        mData.add(new YetLanguage("Scala", "Scala 是一门多范式（multi-paradigm）的编程语言", R.drawable.images));
        mData.add(new YetLanguage("Swift", "Swift 是开发 Mac APP 和 iOS APP 的语言", R.drawable.images));
        mData.add(new YetLanguage("TypeScript", "TypeScript 是一种由微软开发的自由和开源的编程语言", R.drawable.images));

        for (int i = 0; i < 96; i++) {
            mData.add(mData.get(i % 4));
        }

        //创建一个 YetAdapter
        YetAdapter yetAdapter = new YetAdapter(mData, getApplicationContext());

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(yetAdapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
            toast.setText("你点击了第" + position + "项");
            toast.show();
        });
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
        System.out.println(LocalDateTime.now());
    }
}