package com.ronald.lovebatak.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.ronald.lovebatak.model.Project;
import com.ronald.lovebatak.service.ProjectRepository;

import javax.inject.Inject;

public class ProjectViewModel extends AndroidViewModel {

    private static final String TAG = ProjectViewModel.class.getName();
    private static final MutableLiveData ABSENT = new MutableLiveData();
    {
        //noinspection unchecked
        ABSENT.setValue(null);
    }

    private final LiveData<Project> projectObservable;
    private final MutableLiveData<String> projectID;

    public ObservableField<Project> project = new ObservableField<>();

    @Inject
    public ProjectViewModel(@NonNull ProjectRepository projectRepository,  @NonNull Application application) {
        super(application);

        this.projectID = new MutableLiveData<>();
        projectObservable = Transformations.switchMap(projectID, input -> {
            if (input.isEmpty()) {
                Log.i(TAG, "ProjectViewModel projectID is absent!!!");
                return ABSENT;
            }

            Log.i(TAG,"ProjectViewModel projectID is " + projectID.getValue());

            return projectRepository.getProjectDetails("ronald132", projectID.getValue());

        });
    }

    public LiveData<Project> getObservableProject() {
        return projectObservable;
    }

    public void setProject(Project project) {
        this.project.set(project);
    }

    public void setProjectID(String projectID) {
        this.projectID.setValue(projectID);
    }
}
