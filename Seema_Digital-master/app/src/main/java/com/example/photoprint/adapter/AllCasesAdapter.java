package com.example.photoprint.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.photoprint.Activities.FullImageActivity;
import com.example.photoprint.R;
import com.example.photoprint.model.Cases;

import java.util.List;


public class AllCasesAdapter extends RecyclerView.Adapter<AllCasesAdapter.MyViewHolder>{

    public List<Cases> cases;
    List<Cases> petsFilter;
    private Context context;

    public AllCasesAdapter(List<Cases> cases, Context context) {
        this.cases = cases;
        this.petsFilter = cases;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.case_images, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.mTitle.setVisibility(View.GONE);

        holder.mTitle.setText(cases.get(position).getTitle());
        holder.mPicture.setImageResource(cases.get(position).getImage());

        holder.mRowContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FullImageActivity.class);
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cases.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView mPicture;
        private TextView mTitle;
        private RelativeLayout mRowContainer;


        public MyViewHolder(View itemView) {
            super(itemView);
            mPicture = itemView.findViewById(R.id.image);
            mTitle = itemView.findViewById(R.id.title);
            mRowContainer = itemView.findViewById(R.id.row_container);

        }
    }
}
