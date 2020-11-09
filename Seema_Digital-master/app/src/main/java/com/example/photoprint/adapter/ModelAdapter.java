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

import com.example.photoprint.Activities.CaseDetailsActivity;
import com.example.photoprint.Activities.DetailsActivity;
import com.example.photoprint.Activities.ProductsActivity;
import com.example.photoprint.R;
import com.example.photoprint.model.Mobile_Brand;
import com.example.photoprint.model.Mobile_Model;

import java.util.List;


public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.MyViewHolder>{

    public List<Mobile_Model> mobile;
    List<Mobile_Model> petsFilter;
    private Context context;

    public ModelAdapter(List<Mobile_Model> mobile, Context context) {
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
                Intent intent = new Intent(context, CaseDetailsActivity.class);
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
