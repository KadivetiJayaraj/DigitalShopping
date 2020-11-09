package com.example.photoprint.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.photoprint.R;
import com.example.photoprint.Utils.BottomFunctionality;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.signup) TextView signup;
    @BindView(R.id.signin) Button signin;
    @BindView(R.id.btn_merchant) Button btn_merchant;
    @BindView(R.id.btn_customer) Button btn_customer;
    @BindView(R.id.login_type) TextView login_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        BottomFunctionality bottomFunctionality = new BottomFunctionality(LoginActivity.this);
        bottomFunctionality.getfunctionality(this.findViewById(android.R.id.content));

        btn_customer.setBackgroundResource(R.drawable.yellow_background);
        btn_merchant.setBackgroundResource(R.drawable.white_background);
        login_type.setText("Customer");

    }

    @OnClick(R.id.signup)
    public void onSignupClicked(){
    startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
    overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }

    @OnClick(R.id.signin)
    public void onSigninClicked(){
        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.btn_merchant)
    public void onMerchantClicked(){
        btn_customer.setBackgroundResource(R.drawable.white_background);
        btn_merchant.setBackgroundResource(R.drawable.yellow_background);
        login_type.setText("Merchant");
    }

    @OnClick(R.id.btn_customer)
    public void onCustomerClicked(){
        btn_customer.setBackgroundResource(R.drawable.yellow_background);
        btn_merchant.setBackgroundResource(R.drawable.white_background);
        login_type.setText("Customer");
    }
}