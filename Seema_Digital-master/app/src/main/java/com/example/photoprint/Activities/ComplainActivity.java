package com.example.photoprint.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.photoprint.R;
import com.example.photoprint.adapter.CartAdapter;
import com.example.photoprint.adapter.TicketsAdapter;
import com.example.photoprint.model.Cart;
import com.example.photoprint.model.Tickets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ja.burhanrashid52.photoeditor.PhotoEditorView;

public class ComplainActivity extends AppCompatActivity {

    @BindView(R.id.back) ImageView back;
    @BindView(R.id.create_ticket) Button create_ticket;
    @BindView(R.id.linear1) LinearLayout linear1;
    @BindView(R.id.linear2) LinearLayout linear2;
    @BindView(R.id.upload) Button upload;
    @BindView(R.id.image) ImageView image;

    private static final int PICK_REQUEST = 1002;
    Bitmap imageBitmap;

    @BindView(R.id.recycler_ticket) RecyclerView recycler_ticket;

    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Tickets> personUtilsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
        ButterKnife.bind(this);

        linear1.setVisibility(View.VISIBLE);
        linear2.setVisibility(View.GONE);

        recycler_ticket.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_ticket.setLayoutManager(layoutManager);

        personUtilsList = new ArrayList<>();

        for(int i=0;i<2;i++) {
            personUtilsList.add(new Tickets("3210414127", "0352","Mobile Cover","Open","Cancelled"));
        }

        mAdapter = new TicketsAdapter( personUtilsList,this);
        recycler_ticket.setAdapter(mAdapter);

    }

    @OnClick(R.id.back)
    public void OnBack(){
        finish();
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.create_ticket)
    public void OnCreate(){
        linear1.setVisibility(View.GONE);
        linear2.setVisibility(View.VISIBLE);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.upload)
    public void OnUpload(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PICK_REQUEST:
                    try {
                        image.clearFocus();
                        Uri uri = data.getData();
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                        image.setImageBitmap(bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }


}