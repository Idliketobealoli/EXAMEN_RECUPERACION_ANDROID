package com.example.examen_recuperacion_android.horarios.ui.viernes;

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
import com.example.examen_recuperacion_android.databinding.FragmentViernesBinding;

import java.util.List;
import java.util.Objects;

public class ViernesFragment extends Fragment {
    private FragmentViernesBinding binding;
    private RoomDB db;
    private RecyclerView recycler;
    private DatoRecyclerAdapter adapter;
    private LinearLayoutManager manager;
    private List<Dato> datos;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentViernesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        db = RoomDB.getInstance(Objects.requireNonNull(getActivity()).getApplicationContext());
        datos = db.datoDao().findAllByDia("viernes");
        datos.addAll(db.datoDao().findAllByDia("Viernes"));
        datos.addAll(db.datoDao().findAllByDia("VIERNES"));
        datos.addAll(db.datoDao().findAllByDia("V"));
        datos.addAll(db.datoDao().findAllByDia("v"));

        recycler =root.findViewById(R.id.recycler_viernes);
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