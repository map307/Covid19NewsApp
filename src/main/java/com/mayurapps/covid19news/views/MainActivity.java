package com.mayurapps.covid19news.views;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.mayurapps.covid19news.R;
import com.mayurapps.covid19news.ViewModel.MainActivityViewModel;
import com.mayurapps.covid19news.adapter.ArticleAdapter;
import com.mayurapps.covid19news.model.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MainActivity extends AppCompatActivity {

    private static final String ARTICLE_TITLES_STATE = "article_title_state";
    private static final String ARTICLES_STATE = "articles_state";

    private ArrayList<Article> articles = new ArrayList<>();
    private MainActivityViewModel mainActivityViewModel;
    private RecyclerView recyclerView;
    private ArticleAdapter articleAdapter;
    private SwipeRefreshLayout swipeRefresh;

    private ArrayList<String> articleTitles;


    private Parcelable savedRecyclerLayoutState;
    private static final String BUNDLE_RECYCLER_LAYOUT = "recycler_layout";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefresh = findViewById(R.id.swiperefresh);

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateList();
                swipeRefresh.setRefreshing(false);
            }
        });

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        if (savedInstanceState != null) {
            articles = savedInstanceState.getParcelableArrayList(ARTICLES_STATE);
            articleTitles = savedInstanceState.getStringArrayList(ARTICLE_TITLES_STATE);

            savedRecyclerLayoutState = savedInstanceState.getParcelable(BUNDLE_RECYCLER_LAYOUT);
            displayData();
        } else {
            updateList();
        }

    }

    private void displayData() {
        recyclerView = findViewById(R.id.rvArticles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        articleAdapter = new ArticleAdapter(this, articles, (ArrayList<String>) articleTitles);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(articleAdapter);
        restoreLayoutManagerPosition();
        articleAdapter.notifyDataSetChanged();
    }



    private void restoreLayoutManagerPosition() {
        if (savedRecyclerLayoutState != null) {
            recyclerView.getLayoutManager().onRestoreInstanceState(savedRecyclerLayoutState);
        }
    }

    public void updateList() {
        mainActivityViewModel.getAllArticles().observe(this, new Observer<List<Article>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onChanged(List<Article> articlesList) {
                articles = (ArrayList<Article>) articlesList;
                Log.d("articles", articles.toString());
                articleTitles = (ArrayList<String>) articles.stream().map(Article::getTitle).collect(Collectors.toList());
                Log.d("titles", articleTitles.toString());

                initView();

            }
        });
        Toast.makeText(this, getString(R.string.hint), Toast.LENGTH_LONG).show();
    }

    public void initView() {
        recyclerView = findViewById(R.id.rvArticles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        articleAdapter = new ArticleAdapter(this, articles, (ArrayList<String>) articleTitles);
        recyclerView.setAdapter(articleAdapter);
        articleAdapter.notifyDataSetChanged();
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putParcelableArrayList(ARTICLES_STATE, articles);
        savedInstanceState.putStringArrayList(ARTICLE_TITLES_STATE, articleTitles);
        savedInstanceState.putParcelable(BUNDLE_RECYCLER_LAYOUT, recyclerView.getLayoutManager().onSaveInstanceState());
    }
}