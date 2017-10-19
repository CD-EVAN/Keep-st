package com.example.keep_st.util;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.keep_st.R;
import com.example.keep_st.bean.Video;

import java.util.List;

/**
 * Created by lenovo on 2017/9/22.
 */

public class VideoAdapter extends RecyclerView.Adapter  <VideoAdapter.ViewHolder>{

    private Context mContext;
    private List<Video> mVideoList;
    static  class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView videoImage;
        TextView videoTile;

        public ViewHolder(View view){
            super(view);
            cardView = (CardView) view;
            videoImage = (ImageView) view.findViewById(R.id.video_image);
            videoTile = (TextView) view.findViewById(R.id.videoTile_text);

        }
    }
    public VideoAdapter(List<Video> videoList) {
        mVideoList = videoList;
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.video_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return  holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Video video = mVideoList.get(position);
        holder.videoImage.setImageResource(video.getImageId());
        holder.videoTile.setText(video.getVideoTile());
    }

    @Override
    public int getItemCount() {
        return mVideoList.size();
    }
}
