package com.example.photoprint.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.photoprint.R;
import com.example.photoprint.adapter.ProductsAdapter;
import com.example.photoprint.model.Products;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WishListActivity extends AppCompatActivity {

    @BindView(R.id.back) ImageView back;
    @BindView(R.id.recycler_wish) RecyclerView recycler_wish;

    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Products> personUtilsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);
        ButterKnife.bind(this);

        recycler_wish.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this,2);
        recycler_wish.setLayoutManager(layoutManager);

        personUtilsList = new ArrayList<>();

        for(int i=0;i<=15;i++) {
            personUtilsList.add(new Products(R.drawable.case1, "Couple T-Shirts","500","1000"));
        }

        mAdapter = new ProductsAdapter( personUtilsList,this);
        recycler_wish.setAdapter(mAdapter);

    }

    @OnClick(R.id.back)
    public void onBackClicked(){
        startActivity(new Intent(WishListActivity.this,MallActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}