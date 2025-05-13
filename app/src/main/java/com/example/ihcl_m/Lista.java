package com.example.ihcl_m;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Lista extends AppCompatActivity {
    private ListView listView;
    private ArrayList array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listView = (ListView) findViewById(R.id.listview);
        array = new ArrayList<String>();
        array.add("Luis Miguel");
        array.add("José José");
        array.add("Juan Gabriel");
        array.add("Javier Solis");
        array.add("José Alfredo Jimenez");
        array.add("Antonio Aguilar");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(Lista.this, "Haz Hecho Click en " + array.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

}