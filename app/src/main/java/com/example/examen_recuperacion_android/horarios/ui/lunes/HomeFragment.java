package com.example.examen_recuperacion_android.horarios.ui.lunes;

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
import com.example.examen_recuperacion_android.databinding.FragmentHomeBinding;

import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private RoomDB db;
    private RecyclerView recycler;
    private DatoRecyclerAdapter adapter;
    private LinearLayoutManager manager;
    private List<Dato> datos;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        db = RoomDB.getInstance(Objects.requireNonNull(getActivity()).getApplicationContext());
        datos = db.datoDao().findAllByDia("lunes");
        datos.addAll(db.datoDao().findAllByDia("Lunes"));
        datos.addAll(db.datoDao().findAllByDia("LUNES"));
        datos.addAll(db.datoDao().findAllByDia("L"));
        datos.addAll(db.datoDao().findAllByDia("l"));

        recycler =root.findViewById(R.id.recycler_lunes);
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