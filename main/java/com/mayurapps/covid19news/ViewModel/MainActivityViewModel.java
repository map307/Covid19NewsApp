package com.mayurapps.covid19news.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.mayurapps.covid19news.model.Article;
import com.mayurapps.covid19news.service.ArticleRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private ArticleRepository articleRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        articleRepository=new ArticleRepository(application);
    }

    public MutableLiveData<List<Article>> getAllArticles(){
        return articleRepository.getArticles();
    }

    public void clear(){

        articleRepository.clear();
    }

}
