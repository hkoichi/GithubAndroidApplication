package com.app.koichihasegawa.githubsearchapp.presentation.search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.koichihasegawa.githubsearchapp.R;
import com.app.koichihasegawa.githubsearchapp.di.search.SearchModule;
import com.app.koichihasegawa.githubsearchapp.presentation.GithubSearchApp;

import javax.inject.Inject;

public class SearchActivity extends AppCompatActivity {
    @Inject
    SearchPresenter searchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // DI
        ((GithubSearchApp) this.getApplication()).component
                .addSearchComponent(new SearchModule())
                .inject(this);

        // TODO: 検索機能と、レイアウトの追加
    }

}
