package com.example.photoprint.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.photoprint.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CaseDetailsActivity extends AppCompatActivity {

    @BindView(R.id.model) TextView model;
    @BindView(R.id.size) TextView size;
    @BindView(R.id.price) TextView price;
    @BindView(R.id.back) ImageView back;

    @BindView(R.id.select_case) Button select_case;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_details);
        ButterKnife.bind(this);

        String Text = getIntent().getStringExtra("title");
        model.setText(Text);

    }

    @OnClick(R.id.back)
    public void onBack(){
        finish();
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }

    @OnClick(R.id.select_case)
    public void onCaseSelected(){
        startActivity(new Intent(CaseDetailsActivity.this, CategoryCaseActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}