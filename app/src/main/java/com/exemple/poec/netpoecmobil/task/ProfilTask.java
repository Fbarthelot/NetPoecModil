package com.exemple.poec.netpoecmobil.task;

import android.os.AsyncTask;

import com.exemple.poec.netpoecmobil.models.Messages;
import com.exemple.poec.netpoecmobil.models.User;
import com.exemple.poec.netpoecmobil.network.ConnexionService;

import hugo.weaving.DebugLog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilTask extends AsyncTask<Void, Void, Boolean> {
    private ProfilTaskObserver observer;
    private String email;


    public ProfilTask(ProfilTaskObserver observer, String email) {
        this.observer = observer;
        this.email = email;

    }

    @Override
    @DebugLog
    protected Boolean doInBackground(Void... voids) {
        ConnexionService.get().profil(email).enqueue(new Callback<User>() {
            @Override
            @DebugLog
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                observer.onSuccess(user);

            }

            @Override
            @DebugLog
            public void onFailure(Call<User> call, Throwable t) {
                observer.onError();
            }
        });
        return null;
    }

    @Override
    protected void onCancelled() {
        observer.onCancel();
    }

    public interface ProfilTaskObserver {

        void onSuccess(User User);

        void onError();

        void onCancel();

    }
}