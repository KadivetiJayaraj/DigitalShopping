package com.example.photoprint.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.photoprint.R;
import com.example.photoprint.adapter.BrandAdapter;
import com.example.photoprint.adapter.ModelAdapter;
import com.example.photoprint.model.Mobile_Brand;
import com.example.photoprint.model.Mobile_Model;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MobileModelActivity extends AppCompatActivity {

    @BindView(R.id.back) ImageView back;
    @BindView(R.id.recycler_brand) RecyclerView recycler_brand;

    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Mobile_Model> personUtilsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_model);
        ButterKnife.bind(this);

        String Title = getIntent().getStringExtra("title");

        recycler_brand.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this,2);
        recycler_brand.setLayoutManager(layoutManager);

        personUtilsList = new ArrayList<>();

        personUtilsList.add(new Mobile_Model(Title+" Nord"));
        personUtilsList.add(new Mobile_Model(Title+" 7"));
        personUtilsList.add(new Mobile_Model(Title+" 6T"));
        personUtilsList.add(new Mobile_Model(Title+" 6"));
        personUtilsList.add(new Mobile_Model(Title+" 5T"));
        personUtilsList.add(new Mobile_Model(Title+" 5"));
        personUtilsList.add(new Mobile_Model(Title+" X"));

        /*for(int i=0;i<10;i++) {
            personUtilsList.add(new Mobile("OnePlus"));
        }*/

        mAdapter = new ModelAdapter( personUtilsList,this);
        recycler_brand.setAdapter(mAdapter);
    }

    @OnClick(R.id.back)
    public void onClicked(){
        startActivity(new Intent(MobileModelActivity.this,HomeActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}