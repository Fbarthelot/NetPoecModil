package com.exemple.poec.netpoecmobil.task;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.exemple.poec.netpoecmobil.activity.FilmActivity;
import com.exemple.poec.netpoecmobil.activity.LoginActivity;

public class ProfilTask extends AsyncTask<Void, Void, Boolean> implements ConnexionTask.ConnexionTaskObserver{
    @Override
    protected Boolean doInBackground(Void... voids) {


        return null;
    }
    @Override
    public void onSuccess() {

//        Intent intent = new Intent(LoginActivity.this, FilmActivity.class);
//        startActivity(intent);
    }

    @Override
    public void onError() {
//        Toast.makeText(LoginActivity.this, " utilisateur inconnue", Toast.LENGTH_LONG).show();


    }

    @Override
    public void onCancel() {


    }
}
