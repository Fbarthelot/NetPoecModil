package com.exemple.poec.netpoecmobil.network;

import com.exemple.poec.netpoecmobil.models.Messages;
import com.exemple.poec.netpoecmobil.models.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ConnexionApi {
    @FormUrlEncoded
    @POST("connexion/")
    Call<Messages> connexion(@Field("email") String email, @Field("password") String password);


    @GET("connexion/profil")
    Call<User> profil(@Query("email")String email);

}
