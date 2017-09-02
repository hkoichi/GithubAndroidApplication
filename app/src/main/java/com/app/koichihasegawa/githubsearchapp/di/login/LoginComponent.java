package com.app.koichihasegawa.githubsearchapp.di.login;

import com.app.koichihasegawa.githubsearchapp.presentation.login.LoginActivity;

import dagger.Subcomponent;

/**
 * Created by koichihasegawa on 2017/08/31.
 */

@Subcomponent(modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity a);
}
