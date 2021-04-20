package com.mamunsproject.waztube.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mamunsproject.waztube.Full_Screen_vidoe;
import com.mamunsproject.waztube.Model.VideoModel;
import com.mamunsproject.waztube.R;

import java.util.ArrayList;

public class Video_adapter extends RecyclerView.Adapter<Video_adapter.VideoHolder> {

   ArrayList<VideoModel> list;
   Context context;
   int lastPositon=-1;


    public Video_adapter(ArrayList<VideoModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(R.layout.video_sample ,parent,false);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, int position) {


        if (holder.getAdapterPosition()>lastPositon){

            Animation animation= AnimationUtils.loadAnimation(context, R.anim.animation_recycle);
            holder.itemView.startAnimation(animation);


        VideoModel currentPosition= list.get(position);

        holder.webView.loadUrl(currentPosition.getX());
        holder.textView.setText(currentPosition.getT());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context, Full_Screen_vidoe.class);
                intent.putExtra("link",currentPosition.getX());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

        lastPositon=holder.getAdapterPosition();

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VideoHolder extends RecyclerView.ViewHolder {

        WebView webView;
        ImageButton button;
        TextView textView;

        public VideoHolder(@NonNull View itemView) {
            super(itemView);

            webView=itemView.findViewById(R.id.video_view);
            button=itemView.findViewById(R.id.full_screen_btn);
            textView=itemView.findViewById(R.id.title_sample);


            webView.setWebViewClient(new WebViewClient());
            webView.setWebChromeClient(new WebChromeClient());
            webView.getSettings().setJavaScriptEnabled(true);
        }
    }
}
