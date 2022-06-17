package com.example.examen_recuperacion_android;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.examen_recuperacion_android.data.Dato;
import com.example.examen_recuperacion_android.data.RoomDB;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DatoRecyclerAdapter extends RecyclerView.Adapter<DatoRecyclerAdapter.ViewHolder> {
    List<Dato> datos;
    private Activity context;
    private RoomDB db;

    public DatoRecyclerAdapter(List<Dato> datos, Activity context) {
        this.datos = datos;
        this.context = context;

        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public DatoRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dato_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DatoRecyclerAdapter.ViewHolder holder, int position) {
        Dato dato = datos.get(position);

        db = RoomDB.getInstance(context);

        holder.tvHora.setText(String.valueOf(dato.getHora()));
        holder.tvModulo.setText(dato.getModulo());
        holder.tvAula.setText(dato.getAula());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvHora, tvModulo, tvAula;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            tvHora = itemView.findViewById(R.id.tv_hora_item);
            tvModulo = itemView.findViewById(R.id.tv_modulo_item);
            tvAula = itemView.findViewById(R.id.tv_aula_item);
        }
    }
}
