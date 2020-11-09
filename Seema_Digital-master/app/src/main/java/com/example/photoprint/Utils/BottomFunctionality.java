package com.example.photoprint.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.photoprint.Activities.AccountActivity;
import com.example.photoprint.Activities.CartActivity;
import com.example.photoprint.Activities.LoginActivity;
import com.example.photoprint.Activities.HomeActivity;
import com.example.photoprint.Activities.MallActivity;
import com.example.photoprint.Activities.OrderActivity;
import com.example.photoprint.R;


public class BottomFunctionality {
    public final Context context;
    public LinearLayout homeLL, mallLL, orderLL, cartLL, accountLL;

    public BottomFunctionality(Context context) {
        this.context=context;
    }

    public void getfunctionality(View view) {
        homeLL=(LinearLayout)view.findViewById(R.id.home_LL);
        mallLL=(LinearLayout)view.findViewById(R.id.mall_LL);
        orderLL=(LinearLayout)view.findViewById(R.id.order_LL);
        cartLL=(LinearLayout)view.findViewById(R.id.cart_LL);
        accountLL=(LinearLayout)view.findViewById(R.id.account_LL);

        homeLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(context instanceof HomeActivity)){
                    context.startActivity(new Intent(context, HomeActivity.class));
                    ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        mallLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(context instanceof MallActivity)){
                    context.startActivity(new Intent(context, MallActivity.class));
                    ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        orderLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(context instanceof OrderActivity)){
                    context.startActivity(new Intent(context, OrderActivity.class));
                    ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        cartLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(context instanceof CartActivity)){
                    context.startActivity(new Intent(context, CartActivity.class));
                    ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        accountLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(context instanceof AccountActivity)){
                    context.startActivity(new Intent(context, AccountActivity.class));
                    ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });
    }
}
