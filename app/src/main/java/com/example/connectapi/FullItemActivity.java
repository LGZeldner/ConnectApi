package com.example.connectapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FullItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_item);
        // Получаем объект Intent, который запустил данную activity
        Intent intent = getIntent();
        // Получаем строки из объекта intent
        String keyName = intent.getStringExtra("name");
        TextView keyNameView = (TextView) findViewById(R.id.nameFull);
        keyNameView.setText(keyName);
        String keyValue = intent.getStringExtra("value");
        TextView keyValueView = (TextView) findViewById(R.id.valueFull);
        keyValueView.setText(keyValue);

    }
}