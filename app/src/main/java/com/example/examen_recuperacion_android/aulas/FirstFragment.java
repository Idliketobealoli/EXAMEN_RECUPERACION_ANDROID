package com.example.examen_recuperacion_android.aulas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.examen_recuperacion_android.DatoRecyclerAdapter;
import com.example.examen_recuperacion_android.R;
import com.example.examen_recuperacion_android.data.Dato;
import com.example.examen_recuperacion_android.data.RoomDB;
import com.example.examen_recuperacion_android.databinding.FragmentFirstBinding;

import java.util.List;
import java.util.Objects;

public class FirstFragment extends Fragment {
    private RecyclerView recycler;
    private List<Dato> datos;
    private DatoRecyclerAdapter adapter;
    private LinearLayoutManager manager;
    private RoomDB db;

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        db =RoomDB.getInstance(Objects.requireNonNull(getActivity()).getApplicationContext());
        datos = db.datoDao().findAll();

        recycler = root.findViewById(R.id.recycler_aula);
        adapter = new DatoRecyclerAdapter(datos, getActivity());
        manager = new LinearLayoutManager(getActivity().getApplicationContext());

        recycler.setAdapter(adapter);
        recycler.setLayoutManager(manager);

        adapter.notifyDataSetChanged();

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}