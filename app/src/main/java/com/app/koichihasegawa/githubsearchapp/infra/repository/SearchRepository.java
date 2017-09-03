package com.app.koichihasegawa.githubsearchapp.infra.repository;

import com.app.koichihasegawa.githubsearchapp.domain.entity.Repositories;
import com.app.koichihasegawa.githubsearchapp.infra.api.GithubClient;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by koichihasegawa on 2017/08/31.
 */

public class SearchRepository {
    private final GithubClient client;

    @Inject
    public SearchRepository(GithubClient client) {
        this.client = client;
    }

    public Observable<Repositories> getRepositories(String query, String sortType) {
        return client.searchRepository(query, sortType);
    }

    public Observable<Repositories> getRepositories(String query) {
        return client.searchRepository(query);
    }

    public void setAccessToken(String accessToken) {
        client.setAccessToken(accessToken);
    }
}
