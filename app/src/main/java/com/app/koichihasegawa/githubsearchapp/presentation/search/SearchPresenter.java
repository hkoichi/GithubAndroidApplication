package com.app.koichihasegawa.githubsearchapp.presentation.search;

import com.app.koichihasegawa.githubsearchapp.infra.repository.SearchRepository;

import javax.inject.Inject;

/**
 * Created by koichihasegawa on 2017/09/03.
 */

public class SearchPresenter {
    private final SearchRepository searchRepository;

    @Inject
    public SearchPresenter(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }
}
