package com.example.cronometro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Chronometer;
import android.widget.ListView;

import com.example.cronometro.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Chronometer Clock;
    private boolean Running = false;
    private long Pause;

    private List<String> mLista = new ArrayList<>();
    private ArrayAdapter<String> mAdapter;
    private ListView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Clock = (Chronometer) findViewById(R.id.txtTiempo);
        view = (ListView) findViewById(R.id.listVIew);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    public void startChro(View v){
        if(!Running){
            Clock.setBase(SystemClock.elapsedRealtime()- Pause);
            Clock.start();
            Running = true;
        }
    }
    public void finChro(View v){
        if(Running){
            Clock.stop();
            Pause = SystemClock.elapsedRealtime() - Clock.getBase();
            Running = false;
        }
    }

    public void checkChro(View v){
        String text = Clock.getText().toString();
        mLista.add(text);
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mLista);
        view.setAdapter(mAdapter);
    }
}