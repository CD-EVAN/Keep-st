package com.example.keep_st.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.keep_st.R;
import com.example.keep_st.util.TxtReader;

import java.io.InputStream;

public class ArticleActivity extends BaseActivity {

    public static final String ARTICLE_NAME = "articleTile_text";
    public static final String ARTICLE_IMAGE_ID = "article_image";
    public static final String ARTICLE_CONTENT_ID = "article_content";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_activity);
        Intent intent = getIntent();
        String articleName = intent.getStringExtra(ARTICLE_NAME);
        int articleImageId = intent.getIntExtra(ARTICLE_IMAGE_ID,0);
        int articleContentId = intent.getIntExtra(ARTICLE_CONTENT_ID,0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView articleImageVIew = (ImageView) findViewById(R.id.article_image_view);
        TextView articleContentText = (TextView) findViewById(R.id.article_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
        collapsingToolbarLayout.setTitle(articleName);
        Glide.with(this).load(articleImageId).into(articleImageVIew);
        String articleContent = generateArticleContent(articleContentId);
        articleContentText.setText(articleContent);

    }
    private String generateArticleContent(int articleContentId)
    {
        InputStream inputStream = getResources().openRawResource(articleContentId);
        String string = TxtReader.getString(inputStream);
        return string;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
