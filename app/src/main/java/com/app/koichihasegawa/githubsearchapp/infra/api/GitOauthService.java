package com.app.koichihasegawa.githubsearchapp.infra.api;

import com.app.koichihasegawa.githubsearchapp.domain.entity.AccessToken;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by koichihasegawa on 2017/08/31.
 */

public interface GitOauthService {
    @Headers("Accept: applicatoin/json")
    @FormUrlEncoded
    @POST("/login/oauth/access_token")
    Observable<AccessToken> getAccessToken(@Field("code") String code,
                                           @Field("client_id") String clientId,
                                           @Field("client_secret") String clientSecret);
}
