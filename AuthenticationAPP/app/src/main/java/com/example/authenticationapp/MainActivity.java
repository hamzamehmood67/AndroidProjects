package com.example.authenticationapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button signup, Login;
    EditText Name, ID, Email, DOB, Password;

    String NameS, EmailS, PasswordS, DOBS;
    Boolean status=false;
    Long IDS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Name= findViewById(R.id.name);
        ID= findViewById(R.id.ID);
        Email=findViewById(R.id.email);
        DOB=findViewById(R.id.DOB);
        Password=findViewById(R.id.password);

        signup= findViewById(R.id.signup);
        Login=findViewById(R.id.login);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    status=true;
                //Name Validation
                NameS=Name.getText().toString();
                if(NameS.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter valid" +
                            " Name address !", Toast.LENGTH_SHORT).show();
                    Name.setText("");
                    status=false;
                }
                //Email Address Validation
                EmailS=Email.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (!EmailS.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(EmailS).matches()) {

                } else {
                    Toast.makeText(getApplicationContext(), "Enter valid Email address !", Toast.LENGTH_SHORT).show();
                    Email.setText("");
                    status=false;
                }
                //ID Validation
                String temp=ID.getText().toString();
                if(temp.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Invalid " +
                            "ID", Toast.LENGTH_SHORT).show();
                    status=false;
                    ID.setText("");
                }else {
                    IDS=Long.parseLong(temp);
                    if(IDS<=0){
                        Toast.makeText(getApplicationContext(), "Invalid " +
                                "ID", Toast.LENGTH_SHORT).show();
                        status=false;
                        ID.setText("");
                    }
                }

                //DOB Validation

                DOBS=DOB.getText().toString().trim();

                if(!isValidDate(DOBS)){
                    Toast.makeText(getApplicationContext(), "Invalid " +
                            "Date Format", Toast.LENGTH_SHORT).show();
                    DOB.setText("");
                    status=false;
                }
            //PAssword Validation
            PasswordS=Password.getText().toString().trim();
                if(!validatepass(PasswordS))
                {
                    Toast.makeText(getApplicationContext(), "Incorrect Password" +
                            " Format", Toast.LENGTH_SHORT).show();
                    Password.setText("");
                    status=false;

                }
                if(status)
                {
                    Toast.makeText(getApplicationContext(), "Sign Up " +
                            "Successfull", Toast.LENGTH_SHORT).show();
                }

            }



            private boolean isValidDate(String date) {
                if (TextUtils.isEmpty(date)) {
                    return false;
                }

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                sdf.setLenient(false);

                try {
                    Date parsedDate = sdf.parse(date);
                    if (parsedDate != null) {
                        // Additional check to ensure the date is not in the future
                        return !parsedDate.after(new Date());
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                return false;
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

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(status)
               {
                   Intent i=new Intent(getApplicationContext(), MainActivity2.class);
                   i.putExtra("Email",EmailS);
                   i.putExtra("Password",PasswordS);
                   startActivity(i);
               }
               else{
                   Toast.makeText(getApplicationContext(),"Sign Up first", Toast.LENGTH_SHORT).show();
               }
            }
        });



    }
}