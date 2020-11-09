package com.example.photoprint.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.photoprint.R;
import com.example.photoprint.model.Address;
import com.example.photoprint.model.Tickets;

import java.util.List;


public class TicketsAdapter extends RecyclerView.Adapter<TicketsAdapter.MyViewHolder>{

    public List<Tickets> tickets;
    List<Tickets> petsFilter;
    private Context context;

    public TicketsAdapter(List<Tickets> tickets, Context context) {
        this.tickets = tickets;
        this.petsFilter = tickets;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tickets_layout, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.mTicket.setText("Ticket Id :"+tickets.get(position).getTicket_id());
        holder.mOrder.setText("Order Id :"+tickets.get(position).getOrder_id());
        holder.mSubject.setText("Subject :"+tickets.get(position).getSubject());
        holder.mStatus.setText("Status :"+tickets.get(position).getStatus());
        holder.mCategory.setText("Category :"+tickets.get(position).getCategory());

        holder.mRowContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, tickets.get(position).getTicket_id(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView mTicket, mOrder, mSubject, mStatus, mCategory;
        private LinearLayout mRowContainer;


        public MyViewHolder(View itemView) {
            super(itemView);
            mTicket = itemView.findViewById(R.id.ticket_id);
            mOrder = itemView.findViewById(R.id.order_id);
            mSubject = itemView.findViewById(R.id.subject);
            mStatus = itemView.findViewById(R.id.status);
            mCategory = itemView.findViewById(R.id.category);
            mRowContainer = itemView.findViewById(R.id.row_container);

        }
    }
}
