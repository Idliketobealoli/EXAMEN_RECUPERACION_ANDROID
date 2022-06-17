package com.example.examen_recuperacion_android.horarios.ui.martes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.examen_recuperacion_android.DatoRecyclerAdapter;
import com.example.examen_recuperacion_android.R;
import com.example.examen_recuperacion_android.data.Dato;
import com.example.examen_recuperacion_android.data.RoomDB;
import com.example.examen_recuperacion_android.databinding.FragmentDashboardBinding;

import java.util.List;
import java.util.Objects;

public class DashboardFragment extends Fragment {
    private FragmentDashboardBinding binding;
    private RoomDB db;
    private RecyclerView recycler;
    private DatoRecyclerAdapter adapter;
    private LinearLayoutManager manager;
    private List<Dato> datos;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        db = RoomDB.getInstance(Objects.requireNonNull(getActivity()).getApplicationContext());
        datos = db.datoDao().findAllByDia("martes");
        datos.addAll(db.datoDao().findAllByDia("Martes"));
        datos.addAll(db.datoDao().findAllByDia("MARTES"));
        datos.addAll(db.datoDao().findAllByDia("M"));
        datos.addAll(db.datoDao().findAllByDia("m"));

        recycler =root.findViewById(R.id.recycler_martes);
        adapter = new DatoRecyclerAdapter(datos, getActivity());
        manager = new LinearLayoutManager(getActivity().getApplicationContext());
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(manager);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}