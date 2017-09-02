package com.app.koichihasegawa.githubsearchapp.presentation.login;

import android.content.Context;
import android.widget.Toast;

import com.app.koichihasegawa.githubsearchapp.R;
import com.app.koichihasegawa.githubsearchapp.domain.entity.AccessToken;
import com.app.koichihasegawa.githubsearchapp.infra.api.GithubClient;
import com.app.koichihasegawa.githubsearchapp.infra.repository.AccessTokenRepository;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by koichihasegawa on 2017/08/31.
 */

public class LoginPresenter {
    private final AccessTokenRepository accessTokenRepository;
    private final Context context;

    @Inject
    public LoginPresenter(AccessTokenRepository accessTokenRepository, Context context) {
        this.accessTokenRepository = accessTokenRepository;
        this.context = context;
    }

    public void getAccessToken(String code) {
        accessTokenRepository.getAccessToken(code, context.getString(R.string.client_id), context.getString(R.string.client_secret))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AccessToken>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Toast.makeText(context,"subscribe",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(AccessToken value) {
                        GithubClient.setAccessToken(value.getAceessToken());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(context,"onError",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(context,"onComplete",Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
