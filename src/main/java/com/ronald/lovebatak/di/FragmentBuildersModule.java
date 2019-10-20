package com.ronald.lovebatak.di;

import com.ronald.lovebatak.view.ui.ProjectListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract ProjectListFragment contributeProjectListFragment();
}
