package com.example.photoprint.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.photoprint.R;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.email_RL) RelativeLayout emailRL;
    @BindView(R.id.mobile_RL) RelativeLayout mobile_RL;
    @BindView(R.id.address_RL) RelativeLayout address_RL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ButterKnife.bind(this);

        String Text = getIntent().getStringExtra("contact");
        text.setText(Text);
    }

    @OnClick(R.id.back)
    public void onClick(){
        finish();
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.email_RL)
    public void onEmail(){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "abc@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "This is my subject text");
        startActivity(Intent.createChooser(emailIntent, null));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.mobile_RL)
    public void onMobile(){
        if (isPermissionGranted()) {
            call_action();
        }
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.address_RL)
    public void onAddress(){
       /* String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 12.989670, 77.537890);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);*/

        String labelLocation = "SkyCode It Solutions";
        String urlAddress = "http://maps.google.com/maps?q="+ 12.989670  +"," + 77.537890 +"("+ labelLocation + ")&iwloc=A&hl=es";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlAddress));
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }

    private void call_action() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + "9686634909"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);
    }
    private boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG", "Permission is granted");
                return true;
            } else {

                Log.v("TAG", "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG", "Permission is granted");
            return true;
        }
    }


}