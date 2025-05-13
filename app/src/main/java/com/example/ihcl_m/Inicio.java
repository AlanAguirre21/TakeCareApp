package com.example.ihcl_m;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Inicio extends AppCompatActivity implements View.OnClickListener {

    private Button b;
    private EditText e1, e2;
    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        EdgeToEdge.enable(this);


        b = (Button) findViewById(R.id.button2);
        e1 = (EditText) findViewById(R.id.editTextText2);
        e2 = (EditText) findViewById(R.id.editTextText3);
        t = (TextView) findViewById(R.id.textView5);

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v1) {
                String user = "Miguel";
                String password = "12345678";
                String text1 = e1.getText().toString();
                String text2 = e2.getText().toString();

                if (text1.equals(user)) {
                    SpannableString welcomeText = new SpannableString("Bienvenido " + text1);
                    welcomeText.setSpan(new ForegroundColorSpan(Color.GREEN), 0, welcomeText.length(), 0);
                    welcomeText.setSpan(new UnderlineSpan(), 0, welcomeText.length(), 0);
                    e1.setText(welcomeText);

                    if (text2.equals(password)) {
                        SpannableString correctPasswordText = new SpannableString("Contraseña correcta!");
                        correctPasswordText.setSpan(new ForegroundColorSpan(Color.GREEN), 0, correctPasswordText.length(), 0);
                        correctPasswordText.setSpan(new UnderlineSpan(), 0, correctPasswordText.length(), 0);
                        e2.setText(correctPasswordText);
                        Intent intent1 = new Intent(Inicio.this, Window1.class);
                        startActivity(intent1);

                        } else {
                        SpannableString incorrectPasswordText = new SpannableString("Contraseña incorrecta.");
                        incorrectPasswordText.setSpan(new ForegroundColorSpan(Color.BLACK), 0, incorrectPasswordText.length(), 0);
                        incorrectPasswordText.setSpan(new UnderlineSpan(), 0, incorrectPasswordText.length(), 0);
                        incorrectPasswordText.setSpan(new ForegroundColorSpan(Color.RED), 0, incorrectPasswordText.length(), 0);
                        e2.setText(incorrectPasswordText);
                    }
                } else {
                    SpannableString unknownUserText = new SpannableString("Usuario no reconocido.");
                    unknownUserText.setSpan(new ForegroundColorSpan(Color.BLACK), 0, unknownUserText.length(), 0);
                    unknownUserText.setSpan(new UnderlineSpan(), 0, unknownUserText.length(), 0);
                    unknownUserText.setSpan(new ForegroundColorSpan(Color.RED), 0, unknownUserText.length(), 0);
                    e1.setText(unknownUserText);
                }
            }
        });
    }

    @Override
    public void onClick(View v1){
        Intent intent = new Intent(Inicio.this, Window1.class);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
