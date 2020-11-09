package com.example.photoprint.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.photoprint.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecurityActivity extends AppCompatActivity {

    @BindView(R.id.back) ImageView back;
    @BindView(R.id.text) TextView text;
    @BindView(R.id.linear1) LinearLayout linear1;
    @BindView(R.id.linear2) LinearLayout linear2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);
        ButterKnife.bind(this);

        String Text = getIntent().getStringExtra("Details");
        text.setText(Text);

        if(Text.equals("Edit Account"))
        {
            linear1.setVisibility(View.VISIBLE);
            linear2.setVisibility(View.GONE);
        }
        else  if(Text.equals("Change Password"))
        {
            linear1.setVisibility(View.GONE);
            linear2.setVisibility(View.VISIBLE);
        }

    }

    @OnClick(R.id.back)
    public void onBackClicked(){
        finish();
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}