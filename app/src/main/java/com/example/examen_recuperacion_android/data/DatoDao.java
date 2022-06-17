package com.example.examen_recuperacion_android.data;

import androidx.room.*;

import java.util.List;

@Dao
public interface DatoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Dato dato);

    @Query(value = "SELECT * FROM dato")
    List<Dato> findAll();

    @Query("SELECT * FROM dato WHERE dia = :dia ORDER BY hora")
    List<Dato> findAllByDia(String dia);

    @Delete
    void delete(Dato dato);

    @Delete
    void reset(List<Dato> datos);
}
