package com.app.koichihasegawa.githubsearchapp.domain.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by koichihasegawa on 2017/08/31.
 */

public class AccessToken {
    @SerializedName("access_token")
    String access_token;
    @SerializedName("token_type")
    private String token_type;

    public String getAceessToken() {
        return this.access_token;
    }
}
