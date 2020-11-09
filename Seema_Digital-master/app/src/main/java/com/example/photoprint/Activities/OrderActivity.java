package com.example.photoprint.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.photoprint.R;
import com.example.photoprint.Utils.BottomFunctionality;
import com.example.photoprint.adapter.CartAdapter;
import com.example.photoprint.adapter.OrderAdapter;
import com.example.photoprint.model.Cart;
import com.example.photoprint.model.Order;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderActivity extends AppCompatActivity {

    @BindView(R.id.back) ImageView back;
    @BindView(R.id.contact) ImageView contact;
    @BindView(R.id.signup) Button signup;
    @BindView(R.id.login) TextView login;
    @BindView(R.id.no_data) ImageView no_data;
    @BindView(R.id.recycle_orders) RecyclerView recycle_orders;

    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Order> personUtilsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);

        BottomFunctionality bottomFunctionality = new BottomFunctionality(OrderActivity.this);
        bottomFunctionality.getfunctionality(this.findViewById(android.R.id.content));

        recycle_orders.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycle_orders.setLayoutManager(layoutManager);

        personUtilsList = new ArrayList<>();

        for(int i=0;i<10;i++) {
            personUtilsList.add(new Order("56787656","89876","Order Delivered",R.drawable.case1, "Couple T-Shirts","17-10-2020","1000","1050"));
        }

        mAdapter = new OrderAdapter( personUtilsList,this);
        recycle_orders.setAdapter(mAdapter);

        if(layoutManager.getItemCount() == 0 ){
            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
            no_data.setVisibility(View.VISIBLE);
        }

    }
    @OnClick(R.id.back)
    public void onBackClicked(){
        startActivity(new Intent(OrderActivity.this,HomeActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.contact)
    public void onContactClicked(){
        startActivity(new Intent(OrderActivity.this,ContactActivity.class).putExtra("contact","Contact Us"));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.signup)
    public void onSignupClicked(){
        startActivity(new Intent(OrderActivity.this,RegisterActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.login)
    public void onLoginClicked(){
        startActivity(new Intent(OrderActivity.this,LoginActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}