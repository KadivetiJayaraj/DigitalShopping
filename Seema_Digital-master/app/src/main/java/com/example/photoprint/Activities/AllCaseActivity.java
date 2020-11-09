package com.example.photoprint.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.photoprint.R;
import com.example.photoprint.adapter.AllCasesAdapter;
import com.example.photoprint.adapter.CasesAdapter;
import com.example.photoprint.model.Cases;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AllCaseActivity extends AppCompatActivity {

    @BindView(R.id.back) ImageView back;
    @BindView(R.id.title) TextView title;
    @BindView(R.id.recycler_all_cases) RecyclerView recycler_all_cases;

    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Cases> personUtilsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_case);
        ButterKnife.bind(this);

        String Text = getIntent().getStringExtra("Title");
        title.setText(Text);

        recycler_all_cases.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this,3);
        recycler_all_cases.setLayoutManager(layoutManager);

        personUtilsList = new ArrayList<>();
        for(int i=0;i<=15;i++) {
            personUtilsList.add(new Cases(R.drawable.case1, "Most Popular"));
        }

        mAdapter = new AllCasesAdapter( personUtilsList,this);
        recycler_all_cases.setAdapter(mAdapter);

    }

    @OnClick(R.id.back)
    public void onBack(){
        finish();
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}