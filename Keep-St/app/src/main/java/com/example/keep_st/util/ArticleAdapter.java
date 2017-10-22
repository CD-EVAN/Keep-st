package com.example.keep_st.util;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.keep_st.activities.ArticleActivity;
import com.example.keep_st.R;
import com.example.keep_st.bean.Article;

import java.util.List;

/**
 * Created by lenovo on 2017/9/21.
 */

public class ArticleAdapter extends RecyclerView.Adapter <ArticleAdapter.ViewHolder>{

    private Context mContext;
    private List<Article> mActicleList;
    static  class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView articleImage;
        TextView articleTile;
        TextView articleType;
        public ViewHolder(View view){
            super(view);
            cardView = (CardView) view;
            articleImage = (ImageView) view.findViewById(R.id.article_image);
            articleTile = (TextView) view.findViewById(R.id.articleTile_text);
            articleType = (TextView) view.findViewById(R.id.articleType_text);
        }
    }

    public ArticleAdapter(List<Article> articleList) {
         mActicleList = articleList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext ==null) mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.article_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Article article = mActicleList.get(position);
                Intent intent = new Intent(mContext,ArticleActivity.class);
                intent.putExtra(ArticleActivity.ARTICLE_NAME,article.getArticleTile());
                intent.putExtra(ArticleActivity.ARTICLE_IMAGE_ID,article.getImageId());
                intent.putExtra(ArticleActivity.ARTICLE_CONTENT_ID,article.getContentId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Article article = mActicleList.get(position);
        holder.articleImage.setImageResource(article.getImageId());
        holder.articleType.setText(article.getArticleType());
        holder.articleTile.setText(article.getArticleTile());
    }

    @Override
    public int getItemCount() {
        return mActicleList.size();
    }
}
