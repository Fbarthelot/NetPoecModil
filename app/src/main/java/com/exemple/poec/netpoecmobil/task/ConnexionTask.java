package com.exemple.poec.netpoecmobil.task;

import android.os.AsyncTask;

import com.exemple.poec.netpoecmobil.models.Messages;
import com.exemple.poec.netpoecmobil.network.ConnexionService;

import hugo.weaving.DebugLog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConnexionTask extends AsyncTask<Void, Void, Boolean> {
    private ConnexionTaskObserver observer;
    private String email;
    private String password;


    public ConnexionTask(ConnexionTaskObserver observer, String email, String password) {
        this.observer = observer;
        this.email = email;
        this.password = password;
    }

    @Override
    @DebugLog
    protected Boolean doInBackground(Void... voids) {
        ConnexionService.get().connexion(email, password).enqueue(new Callback<Messages>() {
            @Override
            @DebugLog
            public void onResponse(Call<Messages> call, Response<Messages> response) {
                Messages messages = response.body();
                observer.onSuccess(messages);

            }

            @Override
            @DebugLog
            public void onFailure(Call<Messages> call, Throwable t) {
                observer.onError();
            }
        });
        return null;
    }

    @Override
    protected void onCancelled() {
        observer.onCancel();
    }

    public interface ConnexionTaskObserver {

        void onSuccess(Messages messages);

        void onError();

        void onCancel();

    }
}
