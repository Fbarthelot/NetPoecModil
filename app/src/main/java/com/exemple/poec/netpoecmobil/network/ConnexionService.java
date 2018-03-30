package com.exemple.poec.netpoecmobil.network;

import com.exemple.poec.netpoecmobil.models.Messages;
import com.exemple.poec.netpoecmobil.models.User;
import com.orhanobut.logger.Logger;

import java.util.List;

import hugo.weaving.DebugLog;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnexionService {

    private static ConnexionService instance;
    private Retrofit retrofit;
    private ConnexionApi api;

    private ConnexionService() {
        retrofit = new Retrofit.Builder()
                //connexion sur la machine de patrick
//                .baseUrl("http://10.110.11.108:9000/api/")
                //connexion sur la machine de fabien
                .baseUrl("http://10.110.11.110:9000/api/")

                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(ConnexionApi.class);
    }

    public static ConnexionService get() {
        if (instance == null) {
            instance = new ConnexionService();
        }
        return instance;
    }

    @DebugLog
    public Call<Messages> connexion(String email, String password) {

        return api.connexion(email,password);

    }

    @DebugLog
    public Call<User> profil(String email) {

        return api.profil(email);

    }
}
