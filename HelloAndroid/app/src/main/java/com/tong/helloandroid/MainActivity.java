package com.tong.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDateTime;

/**
 * @author matrix
 * @date
 */
public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.tong.helloandroid.MESSAGE";

    private YetAdapter yetAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yetAdapter = new YetAdapter(getApplicationContext());

        ListView listView = findViewById(R.id.listview);
        listView.setEmptyView(findViewById(R.id.empty));
        listView.setAdapter(yetAdapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
            toast.setText("你点击了第" + position + "项");
            toast.show();
        });
    }

    public void add(View view) {
        yetAdapter.add();
    }

    public void remove(View view) {
        yetAdapter.remove();
    }

    public void clear(View view) {
        yetAdapter.clear();
    }

    public void update(View view) {
        yetAdapter.update();
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }



}