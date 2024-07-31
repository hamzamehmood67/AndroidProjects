package com.example.authenticationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

public class MainActivity3 extends AppCompatActivity {

    Button Setpass;
    Boolean status;
    EditText newPass1, newPass2, Email;
    String pass1, pass2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
    Setpass= findViewById(R.id.changePass);

    newPass1=findViewById(R.id.newpassword1);
    newPass2=findViewById(R.id.newpassword2);

    Email=findViewById(R.id.email);

    Bundle extras= getIntent().getExtras();

    String dbEmail=extras.getString("email");

   Setpass.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {

           status=true;
           if(!dbEmail.equals(Email.getText().toString().trim()))
           {
               Toast.makeText(getApplicationContext(),"Invalid Email", Toast.LENGTH_SHORT).show();
               Email.setText("");
               status=false;
           }

          pass1=newPass1.getText().toString().trim();
           pass2=newPass2.getText().toString().trim();

          if(!pass1.equals(pass2))
          {
              Toast.makeText(getApplicationContext(),"Password Mismatch", Toast.LENGTH_SHORT).show();
              status=false;
              newPass1.setText("");
              newPass2.setText("");
          }

          if(!validatepass(pass1))
          {
              Toast.makeText(getApplicationContext(),"Incorrect Password Format", Toast.LENGTH_SHORT).show();
              status=false;
              newPass1.setText("");
              newPass2.setText("");
          }

           if(status)
           {
               Intent i= new Intent(getApplicationContext(), MainActivity2.class);
               i.putExtra("Email", dbEmail);
               i.putExtra("Password", pass1);
               Toast.makeText(getApplicationContext(),"Password Change", Toast.LENGTH_SHORT).show();
               startActivity(i);
           }


       }

       public Boolean validatepass(String password) {

           // check for pattern
           Pattern uppercase = Pattern.compile("[A-Z]");
           Pattern lowercase = Pattern.compile("[a-z]");
           Pattern digit = Pattern.compile("[0-9]");
           Pattern specialChar = Pattern.compile("[!@#$%^&*()_-]");

           // if lowercase character is not present
           if (!lowercase.matcher(password).find()) {
               return false;
           }

           if (!specialChar.matcher(password).find()) {
               return false;
           }
           // if uppercase character is not present
           if (!uppercase.matcher(password).find()) {
               return false;}

           // if digit is not present
           if (!digit.matcher(password).find()) {
               return false;}

           // if password length is less than 8
           if (password.length() < 8) {
               return false;
           }

           return true;
       }
   });


    }
}