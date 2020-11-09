package com.example.photoprint.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.photoprint.Activities.ProductsActivity;
import com.example.photoprint.R;
import com.example.photoprint.model.Home;
import com.example.photoprint.model.Mall;

import java.util.List;


public class MallAdapter extends RecyclerView.Adapter<MallAdapter.MyViewHolder>{

    public List<Mall> mall;
    List<Mall> petsFilter;
    private Context context;

    public MallAdapter(List<Mall> mall, Context context) {
        this.mall = mall;
        this.petsFilter = mall;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mall_items, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.mTitle.setText(mall.get(position).getTitle());
        holder.mDesc.setText(mall.get(position).getDescription());
        holder.mPicture.setImageResource(mall.get(position).getImage());

        holder.mRowContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, mall.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ProductsActivity.class);
                intent.putExtra("title",mall.get(position).getTitle());
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mall.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView mPicture;
        private TextView mTitle, mDesc;
        private RelativeLayout mRowContainer;


        public MyViewHolder(View itemView) {
            super(itemView);
            mPicture = itemView.findViewById(R.id.image);
            mTitle = itemView.findViewById(R.id.title);
            mDesc = itemView.findViewById(R.id.description);
            mRowContainer = itemView.findViewById(R.id.row_container);

        }
    }
}
