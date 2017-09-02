package com.app.koichihasegawa.githubsearchapp.infra.repository;

import com.app.koichihasegawa.githubsearchapp.domain.entity.AccessToken;
import com.app.koichihasegawa.githubsearchapp.infra.api.GitOauthClient;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by koichihasegawa on 2017/08/31.
 */

public class AccessTokenRepository {
    private final GitOauthClient client;

    @Inject
    public AccessTokenRepository(GitOauthClient client) {
        this.client = client;
    }

    public Observable<AccessToken> getAccessToken(String accessCode, String clientId, String clientSecret) {
        return client.getAccessToken(accessCode, clientId, clientSecret);
    }
}
