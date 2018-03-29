package com.exemple.poec.netpoecmobil.task;

import com.exemple.poec.netpoecmobil.network.ConnexionService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConnexionTask  {
    private ConnexionTaskObserver observer;
    private Long id;


    public ConnexionTask(ConnexionTaskObserver observer) {
        this.observer = observer;
    }

    public void postNewUser(String email, String password){
        ConnexionService.get().connexion(email,password).enqueue(new Callback<Long>() {
            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {
                Long id = response.body();
              observer.onSuccess();

            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {
                observer.onError();
            }
        });

    }
    public interface ConnexionTaskObserver {

        void onSuccess();

        void onError();

        void onCancel();

    }
}
