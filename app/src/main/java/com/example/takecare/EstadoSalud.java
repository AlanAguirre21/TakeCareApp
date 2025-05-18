package com.example.takecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class EstadoSalud extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_salud);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(EstadoSalud.this, Home.class);
        startActivity(intent);
    }
}
