package com.example.takecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

class Pregunta {
    public String texto;
    public String[] opciones;
    public int siguienteSi;
    public int siguienteNo;

    public Pregunta(String texto, String[] opciones, int siguienteSi, int siguienteNo) {
        this.texto = texto;
        this.opciones = opciones;
        this.siguienteSi = siguienteSi;
        this.siguienteNo = siguienteNo;
    }
}

public class Diagnostico extends AppCompatActivity implements View.OnClickListener{
    int indiceActual = 0;
    TextView preguntaTexto;
    Button btnSi;
    Button btnNo;
    Button btnSalir;
    Pregunta[] preguntas = new Pregunta[] {
            new Pregunta("¿Tiene fiebre?", new String[]{"Sí", "No"}, 1, 2), // 0
            new Pregunta("¿Lleva más de 7 días con fiebre?", new String[]{"Sí", "No"}, 2, 2), // 1
            new Pregunta("¿Tiene escalofríos?", new String[]{"Sí", "No"}, 3, 6), // 2
            new Pregunta("¿Ha perdido el apetito?", new String[]{"Sí", "No"}, 4, 6), // 3
            new Pregunta("¿Se siente más cansado(a) de lo normal?", new String[]{"Sí", "No"}, 5, 6), // 4
            new Pregunta("¿Ha bajado de peso sin razón aparente?", new String[]{"Sí", "No"}, 6, 15), // 5

            new Pregunta("¿Tiene dificultad para respirar?", new String[]{"Sí", "No"}, 7, 11), // 6
            new Pregunta("¿Tiene tos?", new String[]{"Sí", "No"}, 8, 11), // 7
            new Pregunta("¿La tos es seca?", new String[]{"Sí", "No"}, 9, 11), // 8
            new Pregunta("¿Ha notado sangre al toser?", new String[]{"Sí", "No"}, 39, 10), // 9
            new Pregunta("¿Le duele el pecho al respirar?", new String[]{"Sí", "No"}, 39, 11), // 10

            new Pregunta("¿Ha tenido dolor en el pecho?", new String[]{"Sí", "No"}, 12, 15), // 11
            new Pregunta("¿Siente palpitaciones o el corazón acelerado?", new String[]{"Sí", "No"}, 13, 15), // 12
            new Pregunta("¿Se marea al ponerse de pie o al caminar?", new String[]{"Sí", "No"}, 14, 15), // 13
            new Pregunta("¿Ha tenido hinchazón en los pies o piernas?", new String[]{"Sí", "No"}, 40, 15), // 14

            new Pregunta("¿Ha tenido dolor de cabeza fuerte recientemente?", new String[]{"Sí", "No"}, 16, 21), // 15
            new Pregunta("¿Tiene visión borrosa o doble?", new String[]{"Sí", "No"}, 17, 21), // 16
            new Pregunta("¿Ha sentido debilidad en alguna parte del cuerpo?", new String[]{"Sí", "No"}, 18, 21), // 17
            new Pregunta("¿Ha tenido dificultad para hablar?", new String[]{"Sí", "No"}, 19, 21), // 18
            new Pregunta("¿Ha tenido convulsiones?", new String[]{"Sí", "No"}, 42, 20), // 19
            new Pregunta("¿Ha perdido el conocimiento?", new String[]{"Sí", "No"}, 42, 21), // 20

            new Pregunta("¿Tiene náuseas o vómitos?", new String[]{"Sí", "No"}, 22, 26), // 21
            new Pregunta("¿Tiene diarrea?", new String[]{"Sí", "No"}, 23, 26), // 22
            new Pregunta("¿Ha notado sangre en las heces?", new String[]{"Sí", "No"}, 41, 24), // 23
            new Pregunta("¿Le duele el abdomen?", new String[]{"Sí", "No"}, 41, 25), // 24
            new Pregunta("¿Tiene estreñimiento?", new String[]{"Sí", "No"}, 26, 40), // 25

            new Pregunta("¿Siente ardor al orinar?", new String[]{"Sí", "No"}, 27, 29), // 26
            new Pregunta("¿Orina con más frecuencia de lo normal?", new String[]{"Sí", "No"}, 28, 29), // 27
            new Pregunta("¿Ha notado sangre en la orina?", new String[]{"Sí", "No"}, 41, 29), // 28
            new Pregunta("¿Tiene dolor en la parte baja de la espalda o costado?", new String[]{"Sí", "No"}, 30, 33), // 29

            new Pregunta("¿Tiene dolor en las articulaciones o músculos?", new String[]{"Sí", "No"}, 31, 33), // 30
            new Pregunta("¿Ha tenido una caída o golpe reciente?", new String[]{"Sí", "No"}, 32, 33), // 31
            new Pregunta("¿Tiene hinchazón en alguna parte del cuerpo?", new String[]{"Sí", "No"}, 43, 33), // 32

            new Pregunta("¿Tiene alguna enfermedad crónica?", new String[]{"Sí", "No"}, 34, 36), // 33
            new Pregunta("¿Toma algún medicamento actualmente?", new String[]{"Sí", "No"}, 35, 36), // 34
            new Pregunta("¿Es alérgico(a) a algún medicamento?", new String[]{"Sí", "No"}, 36, 36), // 35
            new Pregunta("¿Está embarazada?", new String[]{"Sí", "No"}, 37, 38), // 36

            new Pregunta("¡Podría tener una infección respiratoria grave!", new String[]{}, -1, -1), // 37
            new Pregunta("Síntomas leves. Mantener observación.", new String[]{}, -1, -1), // 38
            new Pregunta("Posible migraña. Considere consultar un médico.", new String[]{}, -1, -1), // 39
            new Pregunta("Sin síntomas relevantes. Vigilar evolución.", new String[]{}, -1, -1), // 40
            new Pregunta("Posible infección urinaria.", new String[]{}, -1, -1), // 41
            new Pregunta("Posible enfermedad digestive o hemorragia interna.", new String[]{}, -1, -1), // 42
            new Pregunta("Síntomas cardiovasculares preocupantes", new String[]{}, -1, -1), // 43
            new Pregunta("Síntomas neurológicos graves. Atención urgente.", new String[]{}, -1, -1), // 44
            new Pregunta("Riesgo por una enfermedad crónica o trauma reciente.", new String[]{}, -1, -1) // 45
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_diagnostico);

        preguntaTexto = findViewById(R.id.preguntaTexto);
        btnSi = findViewById(R.id.buttonSi);
        btnNo = findViewById(R.id.buttonNo);
        btnSalir = findViewById(R.id.button7);
        btnSalir.setOnClickListener(this);

        mostrarPregunta(indiceActual);
    }

    public void mostrarPregunta(int indice) {
        Pregunta p = preguntas[indice];
        preguntaTexto.setText(p.texto);
        if (indice >= 37){
            btnSi.setVisibility(View.GONE);
            btnNo.setVisibility(View.GONE);
            // Aquí es donde pensaba poner la variable state como condición.
            return;
        }
        btnSi.setOnClickListener(v -> mostrarPregunta(p.siguienteSi));
        btnNo.setOnClickListener(v -> mostrarPregunta(p.siguienteNo));
    }
    public void onClick(View v){
        Intent intent = new Intent(Diagnostico.this, Home.class);
        startActivity(intent);
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}


