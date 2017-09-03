package com.app.koichihasegawa.githubsearchapp.presentation.search;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.app.koichihasegawa.githubsearchapp.domain.entity.Repositories;
import com.app.koichihasegawa.githubsearchapp.infra.repository.SearchRepository;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by koichihasegawa on 2017/09/03.
 */

public class SearchPresenter {
    private final Context context;
    private final SearchRepository searchRepository;

    @Inject
    public SearchPresenter(Context context, SearchRepository searchRepository) {
        this.context = context;
        this.searchRepository = searchRepository;
    }

    public void setUpRecyclerView(final RecyclerView recyclerView) {
        searchRepository.getRepositories("kotlin")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Repositories>() {
                    // TODO: ラムダ式にする
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Repositories value) {
                        SearchListAdapter searchListAdapter = new SearchListAdapter(value.getItems());
                        recyclerView.setAdapter(searchListAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public void getRepositories(String query) {
    }
}
