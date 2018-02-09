package com.poc.app.dagger;


import com.poc.app.MainActivity;
import com.poc.app.detail.DetailsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity activity);

    void inject(DetailsActivity activity);
}
