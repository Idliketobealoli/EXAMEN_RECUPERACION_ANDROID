package com.example.examen_recuperacion_android;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.example.examen_recuperacion_android.data.Dato;
import com.example.examen_recuperacion_android.data.RoomDB;

import java.util.List;

public class DialogDato extends DialogFragment {
    List<Dato> datos;
    RoomDB db;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        db =RoomDB.getInstance(getActivity());
        datos = db.datoDao().findAll();
        AlertDialog.Builder adBuilder =new AlertDialog.Builder(getActivity());
        LayoutInflater inflater =getActivity().getLayoutInflater();
        View dialog =inflater.inflate(R.layout.add_dato_dialog, null);

        EditText etHora = dialog.findViewById(R.id.et_horario_dialog);
        EditText etDia = dialog.findViewById(R.id.et_dia_dialog);
        EditText etModulo = dialog.findViewById(R.id.et_modulo_dialog);
        EditText etAula = dialog.findViewById(R.id.et_aula_dialog);
        Button bAdd = dialog.findViewById(R.id.b_add_dialog);

        adBuilder.setView(dialog);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etHora.getText().toString().isEmpty() &&
                    !etDia.getText().toString().isEmpty() &&
                    !etModulo.getText().toString().isEmpty() &&
                    !etAula.getText().toString().isEmpty()) {
                    if (etDia.getText().toString().equalsIgnoreCase("lunes") ||
                        etDia.getText().toString().equalsIgnoreCase("martes") ||
                        etDia.getText().toString().equalsIgnoreCase("miercoles") ||
                        etDia.getText().toString().equalsIgnoreCase("jueves") ||
                        etDia.getText().toString().equalsIgnoreCase("viernes")) {
                        dismiss();
                        Dato dato = new Dato();
                        dato.setAula(etAula.getText().toString());
                        dato.setModulo(etModulo.getText().toString());
                        dato.setDia(etDia.getText().toString().trim());
                        dato.setHora(etHora.getText().toString());

                        db.datoDao().insert(dato);
                    }
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Invalid fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return adBuilder.create();
    }
}
