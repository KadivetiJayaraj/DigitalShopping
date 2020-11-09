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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.photoprint.Activities.DetailsActivity;
import com.example.photoprint.R;
import com.example.photoprint.model.Home;
import com.example.photoprint.model.Products;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder>{

    public List<Products> products;
    List<Products> petsFilter;
    private Context context;

    public ProductsAdapter(List<Products> products, Context context) {
        this.products = products;
        this.petsFilter = products;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_list, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.mTitle.setText(products.get(position).getTitle());
        holder.mOffer.setText("\u20B9"+products.get(position).getOffer_price());
        holder.mSale.setText("\u20B9"+products.get(position).getSale_price());
        holder.mPicture.setImageResource(products.get(position).getImage());
        holder.mSale.setPaintFlags(holder.mSale.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);

        holder.mLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,products.get(position).getTitle()+" added to WishList",Toast.LENGTH_SHORT).show();
            }
        });

        holder.mGrab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,products.get(position).getTitle()+" added to Cart",Toast.LENGTH_SHORT).show();
            }
        });

        holder.mRowContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("sdcfdc", "onClick: clicked on: " + products.get(position).getTitle());
                Toast.makeText(context, products.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailsActivity.class);
                //intent.putExtra("Title",products.get(position).getTitle());
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView mPicture,mLike;
        private TextView mTitle, mSale, mOffer, mGrab;
        private RelativeLayout mRowContainer;


        public MyViewHolder(View itemView) {
            super(itemView);
            mPicture = itemView.findViewById(R.id.image);
            mLike = itemView.findViewById(R.id.like);
            mTitle = itemView.findViewById(R.id.title);
            mSale = itemView.findViewById(R.id.sale_price);
            mOffer = itemView.findViewById(R.id.offer_price);
            mGrab = itemView.findViewById(R.id.grab);
            mRowContainer = itemView.findViewById(R.id.row_container);

        }
    }
}
