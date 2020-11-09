package com.example.photoprint.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photoprint.Activities.MobileModelActivity;
import com.example.photoprint.R;
import com.example.photoprint.model.Mobile_Brand;

import java.util.List;


public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.MyViewHolder>{

    public List<Mobile_Brand> mobile;
    List<Mobile_Brand> petsFilter;
    private Context context;

    public BrandAdapter(List<Mobile_Brand> mobile, Context context) {
        this.mobile = mobile;
        this.petsFilter = mobile;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mobile_items, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.mTitle.setText(mobile.get(position).getTitle());

        holder.mRowContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, mobile.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MobileModelActivity.class);
                intent.putExtra("title",mobile.get(position).getTitle());
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mobile.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView mTitle;
        private CardView mRowContainer;


        public MyViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mRowContainer = itemView.findViewById(R.id.row_container);
        }
    }
}
