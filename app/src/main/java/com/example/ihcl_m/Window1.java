package com.example.ihcl_m;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public abstract class Window1 extends AppCompatActivity implements View.OnClickListener {

    private Button b1, b2, b3, b4, b5;
    private EditText num1, num2;
    private TextView t;

    @SuppressLint({"MissingInflatedId", "MissingSuperCall"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window1);
        EdgeToEdge.enable(this);

        num1 = (EditText) findViewById(R.id.editTextNum1);
        num2 = (EditText) findViewById(R.id.editTextNum2);
        b1 = (Button) findViewById(R.id.buttonSum);
        b2 = (Button) findViewById(R.id.buttonRes);
        b3 = (Button) findViewById(R.id.buttonMul);
        b4 = (Button) findViewById(R.id.buttonDiv);
        b5 = (Button) findViewById(R.id.button3);

        t = (TextView) findViewById(R.id.textView8);

        b1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String tNum1 = num1.getText().toString();
                String tNum2 = num2.getText().toString();

                int n1 = Integer.parseInt(tNum1);
                int n2 = Integer.parseInt(tNum2);
                int resultado = n1 + n2;

                t.setText("El resultado de la suma es: " + resultado);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String tNum1 = num1.getText().toString();
                String tNum2 = num2.getText().toString();

                int n1 = Integer.parseInt(tNum1);
                int n2 = Integer.parseInt(tNum2);
                int resultado = n1 - n2;

                t.setText("El resultado de la resta es: " + resultado);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String tNum1 = num1.getText().toString();
                String tNum2 = num2.getText().toString();

                int n1 = Integer.parseInt(tNum1);
                int n2 = Integer.parseInt(tNum2);
                int resultado = n1 * n2;

                t.setText("El resultado de la multiplicación es: " + resultado);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String tNum1 = num1.getText().toString();
                String tNum2 = num2.getText().toString();

                int n1 = Integer.parseInt(tNum1);
                int n2 = Integer.parseInt(tNum2);
                int resultado = n1 / n2;

                t.setText("El resultado de la división es: " + resultado);
            }
        });


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_window1);
        b5 = (Button) findViewById(R.id.button3);
        b5.setOnClickListener(this);
    }

    public void onClick(View v3) {
        Intent intent = new Intent(Window1.this, video.class);
        startActivity(intent);
        }

    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
        }


}
