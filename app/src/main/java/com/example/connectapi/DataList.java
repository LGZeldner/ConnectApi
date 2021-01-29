package com.example.connectapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class DataList extends AppCompatActivity {

    // набор данных, которые свяжем со списком
    ArrayList<ApiKey> apiKeysList;
    // создаем адаптер
    ApiKeyListAdapter adapter;
    RecyclerView recyclerView;
    ApiInterface api;
    private CompositeDisposable disposables;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);
        // Получаем объект Intent, который запустил данную activity
        Intent intent = getIntent();
        // Получаем сообщение из объекта intent - имя бога для передачи в API
        String godName = intent.getStringExtra("godName");
        //TextView messageText = (TextView) findViewById(R.id.textView);
        //messageText.setText(godName);
        apiKeysList = new ArrayList<ApiKey>();
        adapter = new ApiKeyListAdapter(this, apiKeysList);
        recyclerView = (RecyclerView) findViewById(R.id.dataList);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        api = ApiConfiguration.getApi();
        disposables = new CompositeDisposable();
        this.onClick(this.recyclerView);
    }

    public void onClick(View view){
        disposables.add(api.apiKeys()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((aKList) -> {
                    apiKeysList.clear();
                    apiKeysList.addAll(aKList.apiKey);
                    adapter.notifyDataSetChanged();
                }, (error) -> Toast.makeText(this, "При поиске возникла ошибка:\n" + error.getMessage(),
                        Toast.LENGTH_LONG).show()));
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (disposables.isDisposed()) {
            disposables.dispose();
        }
    }
}