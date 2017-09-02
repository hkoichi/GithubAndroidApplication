package com.app.koichihasegawa.githubsearchapp.presentation.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.koichihasegawa.githubsearchapp.R;
import com.app.koichihasegawa.githubsearchapp.di.login.LoginModule;
import com.app.koichihasegawa.githubsearchapp.presentation.GithubSearchApp;
import com.app.koichihasegawa.githubsearchapp.presentation.search.SearchActivity;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {
    @Inject
    LoginPresenter loginPresenter;

    final String redirectUri = "hase://app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // DI
        ((GithubSearchApp) this.getApplication()).component
                .addLoginComponent(new LoginModule())
                .inject(this);

        // ブラウザからインテントしているかの場合分け
        if (getIntent().getData() == null) {
            // AccessCode取得のためのインテント
            Intent intent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(getString(R.string.oauth_base_url) +
                            "?client_id=" + getString(R.string.client_id) +
                            "&redirect_uri=" + redirectUri
                    )
            );
            startActivity(intent);
        // ブラウザからインテントされているとき
        } else {
            // AcceccCodeの取得
            String code = getIntent().getData().getQueryParameter("code");
            if (code != null) {
                loginPresenter.getAccessToken(code);
            }
            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);
        }
    }
}
