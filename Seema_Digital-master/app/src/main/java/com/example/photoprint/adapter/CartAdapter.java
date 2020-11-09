package com.example.photoprint.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.photoprint.Activities.ProductsActivity;
import com.example.photoprint.R;
import com.example.photoprint.model.Cart;
import com.example.photoprint.model.Mall;

import java.util.List;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder>{

    public List<Cart> cart;
    List<Cart> petsFilter;
    private Context context;

    public CartAdapter(List<Cart> cart, Context context) {
        this.cart = cart;
        this.petsFilter = cart;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.mTitle.setText(cart.get(position).getTitle());
        holder.mAmount.setText("\u20B9"+cart.get(position).getAmount());
        holder.mPicture.setImageResource(cart.get(position).getImage());

       /* holder.mRowContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, cart.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ProductsActivity.class);
                intent.putExtra("title",cart.get(position).getTitle());
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });*/

        holder.mAddOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.mAddLinear.setVisibility(View.VISIBLE);
                holder.mAddOpen.setVisibility(View.GONE);
            }
        });

        holder.mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cart itemLabel = cart.get(position);
                cart.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, cart.size());
                Toast.makeText(context, "Removed : " + itemLabel, Toast.LENGTH_SHORT).show();
            }
        });

        holder.mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count= Integer.parseInt(String.valueOf(holder.mCount.getText()));
                count++;
                holder.mCount.setText("" + count);
            }
        });

        holder.mRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count= Integer.parseInt(String.valueOf(holder.mCount.getText()));
                if (count == 1) {
                    holder.mCount.setText("1");
                } else {
                    count -= 1;
                    holder.mCount.setText("" + count);
                }
            }
        });

    }





    @Override
    public int getItemCount() {
        return cart.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView mPicture;
        private TextView mTitle, mAmount,mCount;
        private ImageView mDelete;
        private ImageView mRemove,mAdd,mAddOpen;
        private LinearLayout mAddLinear;
        private RelativeLayout mRowContainer;


        public MyViewHolder(View itemView) {
            super(itemView);
            mPicture = itemView.findViewById(R.id.image);
            mTitle = itemView.findViewById(R.id.title);
            mAmount = itemView.findViewById(R.id.amount);
            mRemove = itemView.findViewById(R.id.remove);
            mAdd = itemView.findViewById(R.id.add);
            mCount = itemView.findViewById(R.id.count);
            mDelete = itemView.findViewById(R.id.delete);
            mAddOpen = itemView.findViewById(R.id.add_open);
            mAddLinear = itemView.findViewById(R.id.add_linear);
            mRowContainer = itemView.findViewById(R.id.row_container);

        }
    }
}
