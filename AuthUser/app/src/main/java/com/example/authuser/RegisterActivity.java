package com.example.authuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText textName;
    Button regButton;
    TextView regText;
    DatabaseReference databaseNames;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        databaseNames = FirebaseDatabase.getInstance().getReference("names");
        textName = findViewById(R.id.Name);
        regButton = findViewById(R.id.buttonRegister);
        regText = findViewById(R.id.textViewRegister);
        mAuth = FirebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addName();
            }
        });
    }
    private void addName(){
        String name1 = textName.getText().toString().trim();
        if(!TextUtils.isEmpty(name1)){
            String id = databaseNames.push().getKey();
            FirebaseUser user = mAuth.getCurrentUser();
            String userEmail = user.getEmail().toString().trim();
            Name name  = new Name(id, name1, userEmail);
            databaseNames.child(id).setValue(name);
            //databaseNames.child(id).setValue(userEmail);
            Toast.makeText(RegisterActivity.this, "Name added", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, ProfileActivity.class));
        }
        else{
            Toast.makeText(RegisterActivity.this, "Please give a name", Toast.LENGTH_SHORT).show();
        }
    }
}