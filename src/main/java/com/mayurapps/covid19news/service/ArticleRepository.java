package com.mayurapps.covid19news.service;

import android.app.Application;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;

import com.mayurapps.covid19news.model.Article;
import com.mayurapps.covid19news.model.ArticleDbResponse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ArticleRepository {
    private Application application;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<Article>> articlesLiveData = new MutableLiveData<>();
    private ArrayList<Article> articles;
    private Observable<ArticleDbResponse> articleDbResponseObservable;

    public ArticleRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Article>> getArticles() {

        articles = new ArrayList<>();
        ArticleDataService articleDataService = RetrofitInstance.getService();
        articleDbResponseObservable = articleDataService.getAllArticlesWithRx();

        compositeDisposable.add(articleDbResponseObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<ArticleDbResponse, Observable<Article>>() {
                    @Override
                    public Observable<Article> apply(ArticleDbResponse articleDbResponse) throws Exception {
                        return Observable.fromArray(articleDbResponse.getArticles().toArray(new Article[0]));
                    }
                })
                .subscribeWith(new DisposableObserver<Article>() {
                    @Override
                    public void onNext(Article article) {
                        if (article.getLanguage().equals("en"))
                            articles.add(article);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("err", e.getMessage());
                    }

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onComplete() {
                        Log.d("complete", "true");
                        HashSet<Article> s= new HashSet<>();
                        s.addAll(articles);
                        ArrayList<Article> distinctArticles = new ArrayList<Article>();
                        distinctArticles.addAll(s);

                        DateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss", Locale.ENGLISH);
                        Collections.sort(distinctArticles, new Comparator<Article>() {
                            public int compare(Article o1, Article o2) {
                                Date o1Date, o2Date = null;
                                try {
                                    o1Date = format.parse(o1.getPublishedDate());
                                    o2Date = format.parse(o2.getPublishedDate());
                                    return o2Date.compareTo(o1Date);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                return 0;
                            }
                        });
                        articlesLiveData.postValue(distinctArticles);
                    }
                }));
        return articlesLiveData;
    }

    public void clear() {
        compositeDisposable.clear();
    }
}
