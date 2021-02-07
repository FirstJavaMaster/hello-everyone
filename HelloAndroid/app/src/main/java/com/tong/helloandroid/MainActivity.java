package com.tong.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.tong.helloandroid.config.AppDatabase;
import com.tong.helloandroid.entity.User;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;

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

        //要显示的数据
        String[] strs = {"Android", "iOS", "Java", "Python", "Ruby"};

        // 创建 ArrayAdapter
        // 构造函数的参数，第一个是上下文对象，第二个是列表项的模板，第三个就是数组
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, strs);

        // 获取 ListView 对象
        // 通过调用 setAdapter() 方法为 ListView 设置 Adapter 设置适配器
        ListView listview = findViewById(R.id.listview);
        listview.setAdapter(adapter);
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