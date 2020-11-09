package com.example.photoprint.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.photoprint.R;
import com.example.photoprint.Utils.BottomFunctionality;
import com.example.photoprint.adapter.CartAdapter;
import com.example.photoprint.adapter.MallAdapter;
import com.example.photoprint.model.Cart;
import com.example.photoprint.model.Mall;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CartActivity extends AppCompatActivity {

    @BindView(R.id.back) ImageView back;
    @BindView(R.id.contact) ImageView contact;
    @BindView(R.id.signup) Button signup;
    @BindView(R.id.login) TextView login;
    @BindView(R.id.no_data) ImageView no_data;
    @BindView(R.id.linear3) LinearLayout linear3;
    @BindView(R.id.recycler_cart) RecyclerView recycler_cart;

    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Cart> personUtilsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ButterKnife.bind(this);

        BottomFunctionality bottomFunctionality = new BottomFunctionality(CartActivity.this);
        bottomFunctionality.getfunctionality(this.findViewById(android.R.id.content));

        recycler_cart.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this,2);
        recycler_cart.setLayoutManager(layoutManager);

        personUtilsList = new ArrayList<>();

        for(int i=0;i<10;i++) {
            personUtilsList.add(new Cart(R.drawable.case1, "Couple T-Shirts","1000"));
        }

        mAdapter = new CartAdapter( personUtilsList,this);
        recycler_cart.setAdapter(mAdapter);

        if( layoutManager.getItemCount() == 0 ){
            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
            no_data.setVisibility(View.VISIBLE);
            linear3.setVisibility(View.GONE);
        }



    }



    @OnClick(R.id.back)
    public void onClicked(){
        startActivity(new Intent(CartActivity.this,HomeActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.contact)
    public void onContactClicked(){
        startActivity(new Intent(CartActivity.this,ContactActivity.class).putExtra("contact","Contact Us"));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.signup)
    public void onSignupClicked(){
        startActivity(new Intent(CartActivity.this,RegisterActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.login)
    public void onLoginClicked(){
        startActivity(new Intent(CartActivity.this,LoginActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }


}