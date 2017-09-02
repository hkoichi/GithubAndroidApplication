package com.app.koichihasegawa.githubsearchapp.di.search;

import com.app.koichihasegawa.githubsearchapp.presentation.search.SearchActivity;

import dagger.Subcomponent;

/**
 * Created by koichihasegawa on 2017/09/03.
 */

@Subcomponent(modules = SearchModule.class)
public interface SearchComponent {
    void inject(SearchActivity a);
}
