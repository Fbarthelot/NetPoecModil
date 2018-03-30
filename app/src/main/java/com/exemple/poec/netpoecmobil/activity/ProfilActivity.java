package com.exemple.poec.netpoecmobil.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.exemple.poec.netpoecmobil.R;

import org.parceler.Parcels;

public class ProfilActivity extends AppCompatActivity {
//:TODO ajouter 3 textView pour afficher les attributs du profil
    private String email;
    private String firstName;
    private String lastName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        email = Parcels.unwrap(getIntent().getParcelableExtra("email"));
        firstName = Parcels.unwrap(getIntent().getParcelableExtra("firstName"));
        lastName = Parcels.unwrap(getIntent().getParcelableExtra("lastName"));
        Toast.makeText(ProfilActivity.this, " lastName de l'utilisateur:"+lastName+"", Toast.LENGTH_LONG).show();
    }
}
