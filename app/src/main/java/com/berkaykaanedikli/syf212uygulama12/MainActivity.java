package com.berkaykaanedikli.syf212uygulama12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button ekleBtn;
    EditText eTxtGiris;
    ListView listeeView;
    ArrayList<String> isimListeArray = new ArrayList<>();
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,isimListeArray);
        ekleBtn = findViewById(R.id.button);
        eTxtGiris = findViewById(R.id.editText);
        listeeView = findViewById(R.id.listView);
        listeeView.setAdapter(adapter);

        ekleBtn.setOnClickListener(view ->{
            String isim = eTxtGiris.getText().toString();
            isimListeArray.add(isim);
            adapter.notifyDataSetChanged();
            eTxtGiris.getText().clear();
        });

        listeeView.setOnItemClickListener((adapterView, view, i, l) -> {
            isimListeArray.remove(i);
            adapter.notifyDataSetChanged();
        });
    }
}