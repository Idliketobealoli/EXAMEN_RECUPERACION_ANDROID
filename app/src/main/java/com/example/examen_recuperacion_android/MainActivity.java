package com.example.examen_recuperacion_android;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.examen_recuperacion_android.aulas.AulaActivity;
import com.example.examen_recuperacion_android.horarios.HorarioActivity;

public class MainActivity extends AppCompatActivity {
    ImageView ivAula, ivHorario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivAula = findViewById(R.id.iv_aula_main);
        ivHorario = findViewById(R.id.iv_horarios_main);

        ivAula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AulaActivity.class);
                startActivity(intent);
            }
        });

        ivHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HorarioActivity.class);
                startActivity(intent);
            }
        });
    }
}