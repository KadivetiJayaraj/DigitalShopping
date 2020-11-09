package com.example.photoprint.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.photoprint.R;
import com.example.photoprint.adapter.CasesAdapter;
import com.example.photoprint.model.Cases;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryCaseActivity extends AppCompatActivity {

    @BindView(R.id.back) ImageView back;
    @BindView(R.id.recycler_cases) RecyclerView recycler_cases;

    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Cases> personUtilsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_case);
        ButterKnife.bind(this);

        recycler_cases.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this,3);
        recycler_cases.setLayoutManager(layoutManager);

        personUtilsList = new ArrayList<>();
        personUtilsList.add(new Cases(R.drawable.add_image, "Most Popular"));
        personUtilsList.add(new Cases(R.drawable.case1, "Most Popular"));
        personUtilsList.add(new Cases(R.drawable.case1, "Quotes"));
        personUtilsList.add(new Cases(R.drawable.case1, "3D Design"));
        personUtilsList.add(new Cases(R.drawable.case1, "Miss You"));
        personUtilsList.add(new Cases(R.drawable.case1, "Princess"));
        personUtilsList.add(new Cases(R.drawable.case1, "Couple Cover"));
        personUtilsList.add(new Cases(R.drawable.case1, "Beard Man"));
        personUtilsList.add(new Cases(R.drawable.case1, "Large Pattern"));
        personUtilsList.add(new Cases(R.drawable.case1, "Attitude"));
        personUtilsList.add(new Cases(R.drawable.case1, "Bullet"));

        mAdapter = new CasesAdapter( personUtilsList,this);
        recycler_cases.setAdapter(mAdapter);

    }

    @OnClick(R.id.back)
    public void onBack(){
        finish();
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}