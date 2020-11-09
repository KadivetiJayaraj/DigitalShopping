package com.example.photoprint.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.photoprint.R;
import com.example.photoprint.Utils.BottomFunctionality;
import com.example.photoprint.adapter.CategoryAdapter;
import com.example.photoprint.adapter.HomeAdapter;
import com.example.photoprint.model.Home;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.account) ImageView account;
    @BindView(R.id.recycler_images) RecyclerView recycler_images;
    @BindView(R.id.recycler_category) RecyclerView recycler_category;

    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Home> personUtilsList;

    RecyclerView.Adapter mAdapter1;
    RecyclerView.LayoutManager layoutManager1;
    List<Home> personUtilsList1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        BottomFunctionality bottomFunctionality = new BottomFunctionality(HomeActivity.this);
        bottomFunctionality.getfunctionality(this.findViewById(android.R.id.content));

        recycler_images.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_images.setLayoutManager(layoutManager);

        personUtilsList = new ArrayList<>();
        for(int i=0;i<=5;i++) {
            personUtilsList.add(new Home(R.drawable.banner1, "Mobile Back Case"));
        }

        mAdapter = new HomeAdapter( personUtilsList,this);
        recycler_images.setAdapter(mAdapter);



        /////////Categories
        recycler_category.setHasFixedSize(true);
        layoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recycler_category.setLayoutManager(layoutManager1);

        personUtilsList1 = new ArrayList<>();
        for(int i=0;i<=5;i++) {
            personUtilsList1.add(new Home(R.drawable.case1, "Top Cases"));
        }

        mAdapter1 = new CategoryAdapter( personUtilsList1,this);
        recycler_category.setAdapter(mAdapter1);

    }

    @OnClick(R.id.account)
    public void onAccount(){
        startActivity(new Intent(HomeActivity.this,AccountActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}