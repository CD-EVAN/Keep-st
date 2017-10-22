package com.example.keep_st.framgent;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.keep_st.bean.Article;
import com.example.keep_st.util.ArticleAdapter;
import com.example.keep_st.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/9/20.
 */

public class ReadFragment extends android.support.v4.app.Fragment {
    private List<Article> articleList = new ArrayList<>();
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View readLayout = inflater.inflate(R.layout.read_layout,
                container, false);
        initArticle();
        RecyclerView readRecyclerView = (RecyclerView) readLayout.findViewById(R.id.readrecycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        readRecyclerView.setLayoutManager(layoutManager);
        ArticleAdapter articleAdapter = new ArticleAdapter(articleList);
        readRecyclerView.setAdapter(articleAdapter);

        return readLayout;
    }
    private void initArticle(){
        Article musicLearning = new Article("对音乐的认识",R.drawable.musiclearning,"音乐",R.raw.musiclearning);
        articleList.add(musicLearning);
        Article running = new Article("写给想要开始跑步的人",R.drawable.running,"运动",R.raw.runningtips);
        articleList.add(running);
        Article violin = new Article("小提琴最基本的技巧",R.drawable.violin,"乐器",R.raw.violinlearning);
        articleList.add(violin);
        Article foreignLanguage = new Article("想唱好霉霉新歌？给你几个tips",R.drawable.foreignlanguage,"外语学习",R.raw.foreignlangue);
        articleList.add(foreignLanguage);
    }
}
