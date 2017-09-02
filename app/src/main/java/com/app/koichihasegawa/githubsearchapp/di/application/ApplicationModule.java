package com.app.koichihasegawa.githubsearchapp.di.application;

import android.content.Context;

import com.app.koichihasegawa.githubsearchapp.presentation.GithubSearchApp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by koichihasegawa on 2017/08/31.
 */
@Module
public class ApplicationModule {
    private GithubSearchApp githubSearchApp;

    public ApplicationModule(GithubSearchApp githubSearchApp) {
        this.githubSearchApp = githubSearchApp;
    }

    @Provides
    public Context provideContext() {
        return githubSearchApp;
    }
}

