package com.app.koichihasegawa.githubsearchapp.infra.api;

import com.app.koichihasegawa.githubsearchapp.domain.entity.Repositories;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by koichihasegawa on 2017/08/31.
 */

public interface GithubService {
    @GET("/search/repositories")
    Observable<Repositories> search(@Query("q") String q,
                                    @Query("sort") String sortType,
                                    @Query("access_token") String accessToken);

    @GET("/search/repositories")
    Observable<Repositories> search(@Query("q") String q,
                                    @Query("sort") String sortType);
}
