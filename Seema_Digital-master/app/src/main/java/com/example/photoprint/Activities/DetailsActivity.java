package com.example.photoprint.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.photoprint.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.back) ImageView back;
    @BindView(R.id.add) ImageView add;
    @BindView(R.id.remove) ImageView remove;
    @BindView(R.id.count) TextView mCount;
    @BindView(R.id.seller_RL) RelativeLayout sellerRL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.back)
    public void onBack(){
        finish();
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
   /* @OnClick(R.id.contact)
    public void onContact(){
        startActivity(new Intent(DetailsActivity.this,ContactActivity.class).putExtra("contact","Contact Us"));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }*/

    @OnClick(R.id.seller_RL)
    public void onSellerInfo(){
        startActivity(new Intent(DetailsActivity.this,ContactActivity.class).putExtra("contact","Seller Information"));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }

    @OnClick(R.id.add)
    public void onAdd(){
        int count= Integer.parseInt(String.valueOf(mCount.getText()));
        count++;
        mCount.setText("" + count);
    }

    @OnClick(R.id.remove)
    public void onRemove(){
        int count= Integer.parseInt(String.valueOf(mCount.getText()));
        if (count == 1) {
            mCount.setText("1");
        } else {
            count -= 1;
            mCount.setText("" + count);
            Toast.makeText(DetailsActivity.this, "Items should be minimum 1", Toast.LENGTH_SHORT).show();
        }
    }


}