package com.app.koichihasegawa.githubsearchapp.infra.api;

import com.app.koichihasegawa.githubsearchapp.domain.entity.Repositories;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by koichihasegawa on 2017/08/31.
 */

public class GithubClient {
    private final GithubService service;
    private static String accessToken;

    @Inject
    public GithubClient(GithubService githubService) {
        this.service = githubService;
    }

    public Observable<Repositories> searchRepository(String query, String sortType) {
        return service.search(query, sortType, accessToken);
    }

    public static void setAccessToken(String token) {
        accessToken = token;
    }

    // TODO: デバッグ用なので後で消す
    public String getAccessToken() {
        return accessToken;
    }
}
