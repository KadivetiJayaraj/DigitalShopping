package com.example.photoprint.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.photoprint.R;
import com.example.photoprint.Utils.BottomFunctionality;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AccountActivity extends AppCompatActivity {

    @BindView(R.id.back) ImageView back;
    @BindView(R.id.logout) ImageView logout;
    @BindView(R.id.order_card) CardView order;
    @BindView(R.id.offer_card) CardView offers;
    @BindView(R.id.address_card) CardView address;
    @BindView(R.id.details_card) CardView details;
    @BindView(R.id.password_card) CardView password;
    @BindView(R.id.privacy_card) CardView privacy;
    @BindView(R.id.terms_card) CardView terms;
    @BindView(R.id.refund_card) CardView refund;
    @BindView(R.id.visit_card) CardView visit;
    @BindView(R.id.contact_card) CardView contact;
    @BindView(R.id.feedback_card) CardView feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ButterKnife.bind(this);

        BottomFunctionality bottomFunctionality = new BottomFunctionality(AccountActivity.this);
        bottomFunctionality.getfunctionality(this.findViewById(android.R.id.content));

    }

    @OnClick(R.id.back)
    public void onBackClicked(){
        finish();
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }

    @OnClick(R.id.logout)
    public void onLogoutClicked(){
        user_logout();
    }

    private void user_logout(){
        android.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Are You sure, You want to Logout");
        builder.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(AccountActivity.this,LoginActivity.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                    }
                });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    @OnClick(R.id.order_card)
    public void onOrderClicked(){
        startActivity(new Intent(AccountActivity.this,OrderActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.offer_card)
    public void onOfferClicked(){
        startActivity(new Intent(AccountActivity.this,OffersActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.address_card)
    public void onAddressClicked(){
        startActivity(new Intent(AccountActivity.this, AddressActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.details_card)
    public void onDetailsClicked(){
        startActivity(new Intent(AccountActivity.this,SecurityActivity.class).putExtra("Details","Edit Account"));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.password_card)
    public void onPasswordClicked(){
        startActivity(new Intent(AccountActivity.this, SecurityActivity.class).putExtra("Details", "Change Password"));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.privacy_card)
    public void onPrivacyClicked(){
        String url = "http://www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.terms_card)
    public void onTermsClicked(){
        String url = "http://www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.refund_card)
    public void onRefundClicked(){
        String url = "http://www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.visit_card)
    public void onVisitClicked(){
        String url = "http://www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.contact_card)
    public void onContactClicked(){
        startActivity(new Intent(AccountActivity.this, ContactActivity.class).putExtra("contact","Contact Us"));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.feedback_card)
    public void onFeedbackClicked(){
        startActivity(new Intent(AccountActivity.this, ComplainActivity.class).putExtra("contact","Contact Us"));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}