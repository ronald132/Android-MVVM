package com.ronald.lovebatak.di;

import com.ronald.lovebatak.viewmodel.ProjectListViewModel;
import com.ronald.lovebatak.viewmodel.ProjectViewModel;

import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    ProjectListViewModel projectListViewModel();
    ProjectViewModel projectViewModel();
}
