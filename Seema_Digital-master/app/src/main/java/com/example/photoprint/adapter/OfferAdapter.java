package com.example.photoprint.adapter;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.text.ClipboardManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.photoprint.Activities.MobileBrandActivity;
import com.example.photoprint.R;
import com.example.photoprint.model.Home;
import com.example.photoprint.model.Offers;

import java.util.List;

import static android.content.Context.CLIPBOARD_SERVICE;


public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.MyViewHolder>{

    public List<Offers> offers;
    List<Offers> petsFilter;
    private Context context;

    public OfferAdapter(List<Offers> offers, Context context) {
        this.offers = offers;
        this.petsFilter = offers;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_items, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.mTitle.setText(offers.get(position).getTitle());
        holder.mCode.setText("Use Code : "+offers.get(position).getCode());
        holder.mValid.setText("Valid till : "+offers.get(position).getValid());
        holder.mPicture.setImageResource(offers.get(position).getImage());

        holder.mRowContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                android.content.ClipboardManager myClipboard = (android.content.ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);

                ClipData myClip = ClipData.newPlainText("text", offers.get(position).getCode());
                myClipboard.setPrimaryClip(myClip);

                Toast.makeText(context, "Text Copied",Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return offers.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView mPicture;
        private TextView mTitle,mCode,mValid,mTerms;
        private LinearLayout mRowContainer;


        public MyViewHolder(View itemView) {
            super(itemView);

            mRowContainer = itemView.findViewById(R.id.row_container);
            mPicture = itemView.findViewById(R.id.image);
            mCode = itemView.findViewById(R.id.code);
            mValid = itemView.findViewById(R.id.valid);
            mTitle = itemView.findViewById(R.id.title);
            mTerms = itemView.findViewById(R.id.termsandconditions);

        }

    }
}
