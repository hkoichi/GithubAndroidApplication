package com.app.koichihasegawa.githubsearchapp.di.application;

import com.app.koichihasegawa.githubsearchapp.di.login.LoginComponent;
import com.app.koichihasegawa.githubsearchapp.di.login.LoginModule;
import com.app.koichihasegawa.githubsearchapp.di.search.SearchComponent;
import com.app.koichihasegawa.githubsearchapp.di.search.SearchModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    LoginComponent addLoginComponent(LoginModule loginModule);
    SearchComponent addSearchComponent(SearchModule searchModule);
}
