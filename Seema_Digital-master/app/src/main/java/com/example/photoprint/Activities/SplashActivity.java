package com.example.photoprint.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.example.photoprint.R;

public class SplashActivity extends AppCompatActivity {

    private static final long SPALSH_TIME_OUT = 3000;
    private ProgressBar progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progress=(ProgressBar)findViewById(R.id.progress);
        ValueAnimator animator = ValueAnimator.ofInt(0, progress.getMax());
        animator.setDuration(3000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation){
                progress.setProgress((Integer)animation.getAnimatedValue());
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });
        animator.start();
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                /*if(sessionManager.getID()!=null && !sessionManager.getID().equalsIgnoreCase("")){
                    Log.e("qwerty",sessionManager.getID());
                    Intent intent=new Intent(SplashActivity.this, DashboardActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent=new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }*/

            }
        },SPALSH_TIME_OUT);
    }
}
