package com.example.photoprint.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.photoprint.R;
import com.example.photoprint.adapter.AddressAdapter;
import com.example.photoprint.model.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressFragment extends Fragment {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Address> personUtilsList;

    public static AddressFragment newInstance() {
        return new AddressFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_address, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this.getActivity());
        Log.d("debugMode", "The application stopped after this");
        mRecyclerView.setLayoutManager(layoutManager);

        personUtilsList = new ArrayList<>();

        //Adding Data into ArrayList
        personUtilsList.add(new Address("Kosuricharan@gmail.com","Charan","5/18,Bazar Street","Near Bustand","Vayalpad","Andhra Pradesh","India","517299","9676513909"));


        mAdapter = new AddressAdapter(personUtilsList,getContext());
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }
}