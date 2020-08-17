package com.mayurapps.covid19news.service;


import com.mayurapps.covid19news.model.ArticleDbResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ArticleDataService {

    @Headers({"x-rapidapi-key:cad2ec4990msh9f5abc4a13d042fp11dcb6jsn7e31f3af1272","x-rapidapi-host:covid-19-news.p.rapidapi.com"})
    @GET("v1/covid")
    Observable<ArticleDbResponse> getAllArticlesWithRx();

}
