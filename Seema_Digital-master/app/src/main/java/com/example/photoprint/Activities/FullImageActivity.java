package com.example.photoprint.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.photoprint.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FullImageActivity extends AppCompatActivity {

    @BindView(R.id.back) ImageView back;
    @BindView(R.id.linear_cart) LinearLayout linear_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.back)
    public void onBack(){
        finish();
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.linear_cart)
    public void onCart(){
        Toast.makeText(this, "Item added to Cart", Toast.LENGTH_SHORT).show();
    }
}