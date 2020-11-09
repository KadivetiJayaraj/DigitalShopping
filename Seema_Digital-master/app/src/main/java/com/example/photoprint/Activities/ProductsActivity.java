package com.example.photoprint.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.photoprint.R;
import com.example.photoprint.adapter.MallAdapter;
import com.example.photoprint.adapter.ProductsAdapter;
import com.example.photoprint.model.Mall;
import com.example.photoprint.model.Products;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductsActivity extends AppCompatActivity {

    @BindView(R.id.back) ImageView back;
    @BindView(R.id.wish) ImageView wish;
    @BindView(R.id.title) TextView title;
    @BindView(R.id.sort) RelativeLayout sort;
    @BindView(R.id.filter) RelativeLayout filter;

    @BindView(R.id.recycler_products) RecyclerView recycler_products;

    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Products> personUtilsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        ButterKnife.bind(this);

        String Title = getIntent().getStringExtra("title");
        title.setText(Title);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recycler_products.setLayoutManager(layoutManager);
        recycler_products.setItemAnimator(new DefaultItemAnimator());

        personUtilsList = new ArrayList<>();

        for(int i=0;i<=10;i++) {
            personUtilsList.add(new Products(R.drawable.case1, "Couple T-Shirts","500","1000"));
        }

        mAdapter = new ProductsAdapter( personUtilsList,this);
        recycler_products.setAdapter(mAdapter);


    }


    @OnClick(R.id.back)
    public void onBackClicked(){
        startActivity(new Intent(ProductsActivity.this,MallActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }

    @OnClick(R.id.wish)
    public void onWishClicked(){
        startActivity(new Intent(ProductsActivity.this,WishListActivity.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }

    @OnClick(R.id.sort)
    public void onSortClicked(){
        sort_images();
    }

    @OnClick(R.id.filter)
    public void onFortClicked(){
        filter_images();
    }

   //////////////////////////////////////

    private void sort_images(){
        AlertDialog.Builder builder = new AlertDialog.Builder(ProductsActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_sort,null);
        builder.setView(dialogView);

        ImageView cancel = (ImageView) dialogView.findViewById(R.id.img_cancel);
        RadioGroup rg = (RadioGroup) dialogView.findViewById(R.id.radio_group);
        Button clear = (Button) dialogView.findViewById(R.id.btn_clear);
        Button apply = (Button) dialogView.findViewById(R.id.btn_apply);

        final AlertDialog dialog = builder.create();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.whatsnew:
                        Toast.makeText(ProductsActivity.this, "What's New", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.lowtohigh:
                        Toast.makeText(ProductsActivity.this, "Low To High", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.hightolow:
                        Toast.makeText(ProductsActivity.this, "High To Low", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductsActivity.this, "Clear", Toast.LENGTH_SHORT).show();
            }
        });

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductsActivity.this, "Apply", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }


    private void filter_images(){
        AlertDialog.Builder builder = new AlertDialog.Builder(ProductsActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_filter,null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();

        ImageView cancel = (ImageView) dialogView.findViewById(R.id.img_cancel);
        RelativeLayout price = (RelativeLayout) dialogView.findViewById(R.id.price);
        RelativeLayout color = (RelativeLayout) dialogView.findViewById(R.id.color);
        RelativeLayout size = (RelativeLayout) dialogView.findViewById(R.id.size);
        Button clear = (Button) dialogView.findViewById(R.id.btn_clear);
        Button apply = (Button) dialogView.findViewById(R.id.btn_apply);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductsActivity.this, "Clear", Toast.LENGTH_SHORT).show();
            }
        });

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductsActivity.this, "Apply", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }
}