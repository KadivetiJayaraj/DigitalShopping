package com.example.photoprint.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.photoprint.Activities.ProductsActivity;
import com.example.photoprint.R;
import com.example.photoprint.model.Mall;
import com.example.photoprint.model.Order;

import java.util.List;


public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder>{

    public List<Order> order;
    List<Order> petsFilter;
    private Context context;

    public OrderAdapter(List<Order> order, Context context) {
        this.order = order;
        this.petsFilter = order;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_items, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {


        holder.mOrderId.setText("Order Id : "+order.get(position).getOrder_id());
        holder.mSellerId.setText("Seller Id : "+order.get(position).getSeller_id());
        holder.mStatus.setText(order.get(position).getStatus());
        holder.mTitle.setText(order.get(position).getTitle());
        holder.mDate.setText("Placed On : "+order.get(position).getDate());
        holder.mAmount.setText("Amount : \u20B9"+order.get(position).getAmount());
        holder.mTotalAmount.setText("\u20B9"+order.get(position).getTotal_amount());
        holder.mPicture.setImageResource(order.get(position).getImage());

        holder.mRowContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, order.get(position).getTitle(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context, ProductsActivity.class);
//                intent.putExtra("title",order.get(position).getTitle());
//                context.startActivity(intent);
//                ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }

    @Override
    public int getItemCount() {
        return order.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView mPicture;
        private TextView mOrderId, mSellerId, mStatus, mTitle, mDate, mAmount, mTotalAmount;
        private LinearLayout mRowContainer;


        public MyViewHolder(View itemView) {
            super(itemView);
            mPicture = itemView.findViewById(R.id.image);
            mOrderId = itemView.findViewById(R.id.order_id);
            mSellerId = itemView.findViewById(R.id.seller_id);
            mStatus = itemView.findViewById(R.id.status);
            mTitle = itemView.findViewById(R.id.title);
            mDate = itemView.findViewById(R.id.date);
            mAmount = itemView.findViewById(R.id.amount);
            mTotalAmount = itemView.findViewById(R.id.total_price);
            mRowContainer = itemView.findViewById(R.id.row_container);

        }
    }
}
