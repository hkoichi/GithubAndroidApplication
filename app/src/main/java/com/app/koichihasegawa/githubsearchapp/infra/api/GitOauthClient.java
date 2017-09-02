package com.app.koichihasegawa.githubsearchapp.infra.api;

import com.app.koichihasegawa.githubsearchapp.domain.entity.AccessToken;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by koichihasegawa on 2017/08/31.
 */

public class GitOauthClient {
    private final GitOauthService service;

    @Inject
    public GitOauthClient(GitOauthService service) {
        this.service = service;
    }

    public Observable<AccessToken> getAccessToken(String accessCode, String clientId, String clientSecret) {
        return service.getAccessToken(accessCode, clientId, clientSecret);
    }
}
