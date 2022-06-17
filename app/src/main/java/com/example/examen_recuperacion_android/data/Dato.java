package com.example.examen_recuperacion_android.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dato")
public class Dato {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String dia;
    private String hora;
    private String modulo;
    private String aula;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }
}
