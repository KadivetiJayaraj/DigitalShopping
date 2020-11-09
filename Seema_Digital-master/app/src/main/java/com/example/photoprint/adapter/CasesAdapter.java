package com.example.photoprint.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.photoprint.Activities.AddImageActivity;
import com.example.photoprint.Activities.AllCaseActivity;
import com.example.photoprint.Activities.DetailsActivity;
import com.example.photoprint.R;
import com.example.photoprint.model.Cases;
import com.example.photoprint.model.Products;

import java.util.List;


public class CasesAdapter extends RecyclerView.Adapter<CasesAdapter.MyViewHolder>{

    public List<Cases> cases;
    List<Cases> petsFilter;
    private Context context;

    public CasesAdapter(List<Cases> cases, Context context) {
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


        if(position == 0)
        {
            holder.mTitle.setVisibility(View.GONE);
            holder.mRowContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, AddImageActivity.class);
                    intent.putExtra("Title",cases.get(position).getTitle());
                    context.startActivity(intent);
                    ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            });
        }else{
            holder.mTitle.setVisibility(View.VISIBLE);
            holder.mRowContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, AllCaseActivity.class);
                    intent.putExtra("Title",cases.get(position).getTitle());
                    context.startActivity(intent);
                    ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            });
        }

        holder.mTitle.setText(cases.get(position).getTitle());
        holder.mPicture.setImageResource(cases.get(position).getImage());


    }

    @Override
    public int getItemCount() {
        return cases.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

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
