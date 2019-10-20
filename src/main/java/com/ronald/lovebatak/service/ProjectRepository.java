package com.ronald.lovebatak.service;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ronald.lovebatak.model.Project;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class ProjectRepository {
    private GithubService githubService;

    @Inject
    public ProjectRepository(GithubService githubService) {
        this.githubService = githubService;
    }

    public LiveData<List<Project>> getProjectList(String userId){
        final MutableLiveData<List<Project>> data = new MutableLiveData<>();

        githubService.getProjectList(userId).enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                Log.i("RONALD", "response: " + response.body());
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {
                Log.i("RONALD", "response error");
                data.setValue(null);
            }
        });

        return data;
    }

    public LiveData<Project> getProjectDetails(String userId, String projectName){
        final MutableLiveData<Project> data = new MutableLiveData<>();

        githubService.getProjectDetails(userId, projectName).enqueue(new Callback<Project>() {
            @Override
            public void onResponse(Call<Project> call, Response<Project> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Project> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }
}
