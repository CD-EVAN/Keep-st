package com.example.keep_st.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.keep_st.R;
import com.example.keep_st.bean.Article;
import com.example.keep_st.framgent.MeFragment;
import com.example.keep_st.framgent.PlayFragment;
import com.example.keep_st.framgent.ReadFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private View readLayout;
    private View playLayout;
    private View meLayout;
    private ReadFragment readFragment;
    private PlayFragment playFragment;
    private MeFragment meFragment;
    private ImageView readImage;
    private ImageView playImage;
    private ImageView meImage;
    private TextView readText;
    private TextView playText;
    private TextView meText;
    private FragmentManager fragmentManager;
    private List<Article> articleList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();
        initViews();
        fragmentManager = getSupportFragmentManager();
        setTabSelection(0);


    }



    private void initViews() {
        readLayout = findViewById(R.id.read_layout);
        playLayout = findViewById(R.id.play_layout);
        meLayout = findViewById(R.id.me_layout);
        readImage = (ImageView) findViewById(R.id.read_image);
        playImage = (ImageView) findViewById(R.id.play_image);
        meImage = (ImageView) findViewById(R.id.me_image);
        readText = (TextView) findViewById(R.id.read_text);
        playText = (TextView) findViewById(R.id.play_text);
        meText = (TextView) findViewById(R.id.me_text);
        readLayout.setOnClickListener(this);
        playLayout.setOnClickListener(this);
        meLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.read_layout:
                // 当点击了消息tab时，选中第1个tab
                setTabSelection(0);
                break;
            case R.id.play_layout:
                // 当点击了联系人tab时，选中第2个tab
                setTabSelection(1);
                break;
            case R.id.me_layout:
                // 当点击了动态tab时，选中第3个tab
                setTabSelection(2);
                break;
            default:
                break;
        }
    }

    private void setTabSelection(int index) {

        clearSelection();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case 0:
                readText.setTextColor(Color.BLACK);
                if (readFragment == null) {
                    readFragment = new ReadFragment();
                    transaction.add(R.id.content, readFragment);
                } else {
                    transaction.show(readFragment);
                }
                break;
            case 1:
                playText.setTextColor(Color.BLACK);
                if (playFragment == null) {
                    playFragment = new PlayFragment();
                    transaction.add(R.id.content, playFragment);
                } else {
                    transaction.show(playFragment);
                }
                break;
            case 2:
                meText.setTextColor(Color.BLACK);
                if (meFragment == null) {
                    meFragment = new MeFragment();
                    transaction.add(R.id.content, meFragment);
                } else {
                    transaction.show(meFragment);
                }
                break;

        }
        transaction.commit();

    }



    private void clearSelection() {

        readText.setTextColor(Color.parseColor("#82858b"));
        playText.setTextColor(Color.parseColor("#82858b"));
        meText.setTextColor(Color.parseColor("#82858b"));

    }
    private void hideFragments(FragmentTransaction transaction) {
        if (readFragment != null) {
            transaction.hide(readFragment);
        }
        if (playFragment != null) {
            transaction.hide(playFragment);
        }
        if (meFragment != null) {
            transaction.hide(meFragment);
        }
    }
}
