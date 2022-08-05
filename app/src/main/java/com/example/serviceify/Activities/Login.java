package com.example.serviceify.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.serviceify.R;
import com.google.firebase.auth.FirebaseAuth;
import Service.Auth;

public class Login extends AppCompatActivity {

    EditText email,password;
    Button login;
    Auth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);

        auth=new Auth();
        auth.firebaseAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null){
                    changeActivity();
                }
            }
        });

        setContentView(R.layout.activity_login);
        email=findViewById(R.id.login_email);
        password=findViewById(R.id.login_password);
        login=findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
    }

     void loginUser() {
        auth.login(email.getText().toString(),password.getText().toString(),getApplicationContext());
    }
    void changeActivity(){

        Intent intent = new Intent(Login.this, HomeCustomer.class);
        startActivity(intent);
        finish();

    }
}