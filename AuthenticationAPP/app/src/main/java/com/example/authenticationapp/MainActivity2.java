package com.example.authenticationapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.BoringLayout;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    EditText inputEmail, inputPassword;
    String userEmail, userPass;
    Boolean status;
    Button Login, forgetPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
       Login=findViewById(R.id.login);
       forgetPass=findViewById(R.id.forgetPass);
       inputPassword=findViewById(R.id.password);
       inputEmail=findViewById(R.id.email);


       String dbEmail, dbPassword;

       Bundle extras= getIntent().getExtras();
       dbEmail=extras.getString("Email");
       dbPassword=extras.getString("Password");

       Login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               status=true;
               userEmail=inputEmail.getText().toString().trim();
               String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
               if (!userEmail.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {

               } else {
                   Toast.makeText(getApplicationContext(), "Enter Valid Email!", Toast.LENGTH_SHORT).show();
                   inputEmail.setText("");
               }

               userPass=inputPassword.getText().toString().trim();
               if(userPass.length()==0)
               {
                   Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();

               }

               if(!dbEmail.equals(userEmail))
               {
                   Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_SHORT).show();
                   status=false;
               }
               if(!dbPassword.equals(userPass))
               {
                   Toast.makeText(getApplicationContext(), "Invalid Password", Toast.LENGTH_SHORT).show();
                   status=false;
               }

               if(status)
               {
                   Toast.makeText(getApplicationContext(), "Log in Successfull", Toast.LENGTH_SHORT).show();
               }
               else
               {
                   Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
               }

           }
       });

       forgetPass.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i= new Intent(getApplicationContext(), MainActivity3.class);
               i.putExtra("email", dbEmail);
               startActivity(i);
           }
       });
    }
}