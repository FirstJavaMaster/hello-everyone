package com.tong.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.appcompat.app.AppCompatActivity;
import com.tong.helloandroid.config.AppDatabase;
import com.tong.helloandroid.entity.User;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author matrix
 * @date
 */
public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.tong.helloandroid.MESSAGE";

    private final String[] langs = new String[]{
            "Kotlin",
            "Scala",
            "Swift",
            "TypeScript"
    };

    private final String[] descs = new String[]{
            "Kotlin 是运行在 Java 虚拟机上的静态语言，被称之为 Android 世界的 Swift",
            "Scala 是一门多范式（multi-paradigm）的编程语言",
            "Swift 是开发 Mac APP 和 iOS APP 的语言",
            "TypeScript 是一种由微软开发的自由和开源的编程语言"
    };

    private final int[] icons = new int[]{
            R.drawable.images,
            R.drawable.images,
            R.drawable.images,
            R.drawable.images
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Map<String, Object>> listitem = new ArrayList<>();
        for (int i = 0; i < langs.length; i++) {
            Map<String, Object> showitem = new HashMap<>();
            showitem.put("icon", icons[i]);
            showitem.put("name", langs[i]);
            showitem.put("desc", descs[i]);
            listitem.add(showitem);
        }

        //创建一个simpleAdapter
        SimpleAdapter myAdapter = new SimpleAdapter(getApplicationContext(), listitem, R.layout.list_item,
                new String[]{"icon", "name", "desc"}, new int[]{R.id.icon, R.id.name, R.id.desc});

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(myAdapter);
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