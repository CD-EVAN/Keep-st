package com.example.keep_st.framgent;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.keep_st.R;
import com.example.keep_st.bean.Video;
import com.example.keep_st.util.VideoAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/9/20.
 */

public class PlayFragment extends android.support.v4.app.Fragment {

    private List<Video> videoList = new ArrayList<>();
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View playLayout = inflater.inflate(R.layout.play_layout,
                container, false);
        initVideo();
        RecyclerView playRecyclerView = (RecyclerView) playLayout.findViewById(R.id.playrecycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        playRecyclerView.setLayoutManager(layoutManager);
        VideoAdapter videoAdapter = new VideoAdapter(videoList);
        playRecyclerView.setAdapter(videoAdapter);



        return playLayout;
    }
    private void initVideo(){
        Video sport1 = new Video("腹肌撕裂者",R.drawable.sport1);
        videoList.add(sport1);
        Video sport2 = new Video("一起燃起来",R.drawable.sport2);
        videoList.add(sport2);
        Video learnjapanese = new Video("零基础学习日语",R.drawable.learnjapanese);
        videoList.add(learnjapanese);
        Video studygame = new Video("3D游戏，原来游戏制作离你这么近",R.drawable.studygame);
        videoList.add(studygame);
    }

}

