package com.example.photoprint.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.photoprint.R;
import com.example.photoprint.adapter.ModelAdapter;
import com.example.photoprint.adapter.OfferAdapter;
import com.example.photoprint.model.Mobile_Model;
import com.example.photoprint.model.Offers;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OffersActivity extends AppCompatActivity {

    @BindView(R.id.back) ImageView back;
    @BindView(R.id.recycler_offers) RecyclerView recycler_offers;

    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Offers> personUtilsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);
        ButterKnife.bind(this);

        recycler_offers.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_offers.setLayoutManager(layoutManager);

        personUtilsList = new ArrayList<>();

        for(int i=0;i<10;i++) {
            personUtilsList.add(new Offers(R.drawable.case1,"Buy one get one free", "DIWALI","1/12/2020"));
        }

        mAdapter = new OfferAdapter( personUtilsList,this);
        recycler_offers.setAdapter(mAdapter);
    }

    @OnClick(R.id.back)
    public void onClicked(){
        startActivity(new Intent(OffersActivity.this,HomeActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}