package com.example.examen_recuperacion_android.horarios.ui.jueves;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.examen_recuperacion_android.DatoRecyclerAdapter;
import com.example.examen_recuperacion_android.R;
import com.example.examen_recuperacion_android.data.Dato;
import com.example.examen_recuperacion_android.data.RoomDB;
import com.example.examen_recuperacion_android.databinding.FragmentJuevesBinding;

import java.util.List;
import java.util.Objects;

public class JuevesFragment extends Fragment {
    private FragmentJuevesBinding binding;
    private RoomDB db;
    private RecyclerView recycler;
    private DatoRecyclerAdapter adapter;
    private LinearLayoutManager manager;
    private List<Dato> datos;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentJuevesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        db = RoomDB.getInstance(Objects.requireNonNull(getActivity()).getApplicationContext());
        datos = db.datoDao().findAllByDia("jueves");
        datos.addAll(db.datoDao().findAllByDia("Jueves"));
        datos.addAll(db.datoDao().findAllByDia("JUEVES"));
        datos.addAll(db.datoDao().findAllByDia("J"));
        datos.addAll(db.datoDao().findAllByDia("j"));

        recycler =root.findViewById(R.id.recycler_jueves);
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