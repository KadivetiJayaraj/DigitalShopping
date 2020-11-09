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
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.photoprint.Activities.ProductsActivity;
import com.example.photoprint.R;
import com.example.photoprint.model.Address;
import com.example.photoprint.model.Mall;

import java.util.List;


public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.MyViewHolder>{

    public List<Address> address;
    List<Address> petsFilter;
    private Context context;

    public AddressAdapter(List<Address> address, Context context) {
        this.address = address;
        this.petsFilter = address;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_items, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.mEmail.setText(address.get(position).getEmail());
        holder.mName.setText(address.get(position).getName());
        holder.mHouseNo.setText(address.get(position).getHouse_no());
        holder.mLandmark.setText(address.get(position).getLandmark());
        holder.mCity.setText(address.get(position).getCity()+" , "+address.get(position).getState());
        holder.mCountry.setText(address.get(position).getCountry()+" - "+address.get(position).getPincode());
        holder.mPhoneNo.setText(address.get(position).getPhone_no());

        holder.mRowContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, address.get(position).getEmail(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context, ProductsActivity.class);
//                intent.putExtra("title",address.get(position).getTitle());
//                context.startActivity(intent);
//                ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }

    @Override
    public int getItemCount() {
        return address.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView mEmail, mName, mHouseNo, mLandmark, mCity, mCountry, mPhoneNo, mEdit;
        private RelativeLayout mRowContainer;


        public MyViewHolder(View itemView) {
            super(itemView);
            mEmail = itemView.findViewById(R.id.email);
            mName = itemView.findViewById(R.id.name);
            mHouseNo = itemView.findViewById(R.id.house_no);
            mLandmark = itemView.findViewById(R.id.landmark);
            mCity = itemView.findViewById(R.id.city);
            mCountry = itemView.findViewById(R.id.country);
            mPhoneNo = itemView.findViewById(R.id.phone_no);
            mEdit = itemView.findViewById(R.id.edit);
            mRowContainer = itemView.findViewById(R.id.row_container);

        }
    }
}
