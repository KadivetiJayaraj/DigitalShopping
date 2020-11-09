package com.example.photoprint.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.photoprint.R;
import com.example.photoprint.Utils.Banner;
import com.example.photoprint.Utils.BottomFunctionality;
import com.example.photoprint.adapter.HomeAdapter;
import com.example.photoprint.adapter.MallAdapter;
import com.example.photoprint.model.Home;
import com.example.photoprint.model.Mall;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MallActivity extends AppCompatActivity {

    @BindView(R.id.back) ImageView back;
    @BindView(R.id.cart) ImageView cart;

    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @BindView(R.id.recycler_mall)
    RecyclerView recycler_mall;

    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Mall> personUtilsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall);
        ButterKnife.bind(this);

        BottomFunctionality bottomFunctionality = new BottomFunctionality(MallActivity.this);
        bottomFunctionality.getfunctionality(this.findViewById(android.R.id.content));

        Banner banner = new Banner(MallActivity.this);
        banner.getHowToWorkData(viewpager);

        recycler_mall.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this,2);
        recycler_mall.setLayoutManager(layoutManager);

        personUtilsList = new ArrayList<>();

        for(int i=0;i<=10;i++) {
            personUtilsList.add(new Mall(R.drawable.case1, "Couple T-Shirts","Couple T-Shirts and Phants"));
        }

        mAdapter = new MallAdapter( personUtilsList,this);
        recycler_mall.setAdapter(mAdapter);

    }


    @OnClick(R.id.back)
    public void onBackClicked(){
        startActivity(new Intent(MallActivity.this,HomeActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.cart)
    public void onCartClicked(){
        startActivity(new Intent(MallActivity.this,CartActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}