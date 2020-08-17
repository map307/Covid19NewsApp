package com.mayurapps.covid19news.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mayurapps.covid19news.R;
import com.mayurapps.covid19news.model.Article;
import com.mayurapps.covid19news.views.ArticleActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private Context context;
    private ArrayList<String> articleTitles;
    private ArrayList<Article> articles;
    private ArrayList<String> urls = new ArrayList<>();

    public ArticleAdapter(Context context,ArrayList<Article> articles, ArrayList<String> articleTitles) {
        this.context = context;
        this.articleTitles = articleTitles;
        this.articles = articles;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_list_item, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.articleTitle.setText(articles.get(position).getTitle());
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss", Locale.ENGLISH);
        holder.articleDate.setText("Published Date & Time : "+ articles.get(position).getPublishedDate());

        if(!articles.get(position).getSummary().equals("")) {
            holder.articleSummary.setText(articles.get(position).getSummary());
        }
        else if(!articles.get(position).getTopic().equals("NA")) {

            holder.articleSummary.setText(articles.get(position).getTopic());
        }
        else {
            holder.articleSummary.setText(articles.get(position).getTitle());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("selected summary: ",articles.get(position).getSummary());

                Intent intent = new Intent(context.getApplicationContext(), ArticleActivity.class);
                intent.putExtra("url", articles.get(position).getLink());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return articleTitles.size();
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        urls.clear();
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder{

        public TextView articleTitle;
        public TextView articleSummary;
        public TextView articleDate;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            articleTitle=itemView.findViewById(R.id.articleTitle);
            articleSummary=itemView.findViewById(R.id.summary);
            articleDate = itemView.findViewById(R.id.articleDate);
        }

    }

}
