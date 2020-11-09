package com.example.photoprint.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.photoprint.Activities.MobileBrandActivity;
import com.example.photoprint.R;
import com.example.photoprint.model.Home;

import java.util.List;

import javax.xml.transform.Result;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{

    public List<Home> home;
    List<Home> petsFilter;
    private Context context;

    public HomeAdapter(List<Home> home, Context context) {
        this.home = home;
        this.petsFilter = home;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_images, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.mRowContainer.setTag(position);

        holder.mTitle.setText(home.get(position).getText());
        holder.mPicture.setImageResource(home.get(position).getImage());

        holder.mRowContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("sdcfdc", "onClick: clicked on: " + home.get(position).getText());
                Toast.makeText(context, home.get(position).getText(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MobileBrandActivity.class);
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

    }

    @Override
    public int getItemCount() {
        return home.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView mPicture;
        private TextView mTitle;
        private Button mShop;
        private LinearLayout mRowContainer;


        public MyViewHolder(View itemView) {
            super(itemView);

            mPicture = itemView.findViewById(R.id.image);
            mTitle = itemView.findViewById(R.id.title);
            mShop = itemView.findViewById(R.id.shop);
            mRowContainer = itemView.findViewById(R.id.row_container);

            mRowContainer.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }
    }
}
