package com.app.koichihasegawa.githubsearchapp.presentation;

import android.app.Application;

import com.app.koichihasegawa.githubsearchapp.di.application.ApplicationComponent;
import com.app.koichihasegawa.githubsearchapp.di.application.ApplicationModule;
import com.app.koichihasegawa.githubsearchapp.di.application.DaggerApplicationComponent;

/**
 * Created by koichihasegawa on 2017/08/31.
 */

public class GithubSearchApp extends Application {
    public ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

}
