package com.ronald.lovebatak.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ronald.lovebatak.model.Project;
import com.ronald.lovebatak.service.ProjectRepository;

import java.util.List;

import javax.inject.Inject;

public class ProjectListViewModel extends AndroidViewModel {
    private final LiveData<List<Project>> projectListObservable;

    @Inject
    public ProjectListViewModel(@NonNull ProjectRepository projectRepository, @NonNull Application application) {
        super(application);

        projectListObservable = projectRepository.getProjectList("Google");
    }

    public LiveData<List<Project>> getProjectListObservable(){
        return projectListObservable;
    }
}
