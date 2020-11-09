package com.example.photoprint.Utils;

import android.content.Context;
import android.widget.LinearLayout;

import androidx.viewpager.widget.ViewPager;

import com.example.photoprint.R;
import com.example.photoprint.adapter.BannerAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Banner {
    private Context context;
    private LinearLayout ll_review_rate_list;
    private ArrayList<Integer> dataArray_banner;
    public Banner(Context context, LinearLayout ll_review_rate_list){
        this.context = context;
        this.ll_review_rate_list = ll_review_rate_list;
    }

    private String loadMore = "0";
    public Banner(Context context){
        this.context = context;
    }
    public void getHowToWorkData(final ViewPager viewPager){
        dataArray_banner=new ArrayList<>();
        dataArray_banner.add(R.drawable.slide1);
        dataArray_banner.add(R.drawable.slide2);
        dataArray_banner.add(R.drawable.slide3);
        dataArray_banner.add(R.drawable.slide4);
        dataArray_banner.add(R.drawable.slide5);


//        JsonArrayRequest code_verify_request = new JsonArrayRequest(Request.Method.GET,A_Service_URL.getUrl+"banners.php",null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        try {
//                            for(int i=0;i<response.length();i++){
//                                JSONObject jsonObject=response.getJSONObject(i);
//                                String baneer_img = jsonObject.getString("baneer_img");
//                                dataArray_banner.add(baneer_img);
//                            }
//                            slider(viewPager,dataArray_banner);
//                        }
//                        catch (JSONException e) {
//                            A_Service_URL.getToast(context,""+e);
//                            e.printStackTrace(); }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getApplicationContext(),"Try Again"+error,Toast.LENGTH_LONG).show();
//                if (error instanceof NetworkError) {
//                    Toast.makeText(getApplicationContext(),"Network Error",Toast.LENGTH_SHORT).show();
//                } else if (error instanceof AuthFailureError) {
//                    Toast.makeText(getApplicationContext(),"Auth Failed Error",Toast.LENGTH_SHORT).show();
//                } else if (error instanceof ParseError) {
//                    Toast.makeText(getApplicationContext(),"Parse Error",Toast.LENGTH_SHORT).show();
//                } else if (error instanceof TimeoutError) {
//                    Toast.makeText(getApplicationContext(),"Time Out Error", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        int socketTimeout = 400000;
//        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
//        code_verify_request.setRetryPolicy(policy);
//        RequestQueue rq = Volley.newRequestQueue(context);
//        rq.add(code_verify_request);

        slider(viewPager,dataArray_banner);
    }

    // show to sliding banner
    private void slider(final ViewPager view_pager_banner, final ArrayList<Integer> dataArray_banner) {
        view_pager_banner.setAdapter(new BannerAdapter(context, dataArray_banner));

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                view_pager_banner.post(new Runnable(){
                    @Override
                    public void run() {
                        view_pager_banner.setCurrentItem((view_pager_banner.getCurrentItem()+1) % dataArray_banner.size());
                    }
                });
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 3000, 3000);
    }
}
