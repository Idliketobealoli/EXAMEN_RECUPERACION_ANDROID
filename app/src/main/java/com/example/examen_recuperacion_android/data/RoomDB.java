package com.example.examen_recuperacion_android.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Dato.class}, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    private static RoomDB db;
    public abstract DatoDao datoDao();

    public synchronized static RoomDB getInstance(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context.getApplicationContext(), RoomDB.class, "db_datos")
                    .fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return db;
    }
}
