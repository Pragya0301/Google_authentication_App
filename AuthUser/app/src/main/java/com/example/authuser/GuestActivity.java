package com.example.authuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class GuestActivity extends AppCompatActivity {
    TextView textGuest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        textGuest = findViewById(R.id.textViewGuest);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}