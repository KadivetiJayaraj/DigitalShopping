package com.example.photoprint.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import com.example.photoprint.R;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {

    private ArrayList<Integer> images;
    private Context context;

    public BannerAdapter(Context context, ArrayList<Integer> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 120);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        if(images.get(position) != null && !images.get(position).equals("")) {
//            Picasso.get().load(A_Service_URL.getImageUrl+images.get(position)).noFade().centerCrop()
//                    .placeholder(R.drawable.progress_loading)
//                    .error(R.drawable.warning).fit().noFade().into(imageView);
            imageView.setImageResource(images.get(position));
        }
        else
            imageView.setVisibility(View.GONE);
        view.addView(imageView);
        return imageView;
    }
}