package com.example.databaseconnectivity;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

public class MainActivity extends AppCompatActivity {

        Spinner sp;
        Button adduser;
        EditText username;
        EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        sp=findViewById(R.id.spinnerUsers);
        username=findViewById(R.id.etUserName);
        password=findViewById(R.id.etPassword);
        adduser=findViewById(R.id.btnAddUser);
        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHandler db= new DatabaseHandler(getApplicationContext());
                User newUser=new User(username.getText().toString(),password.getText().toString());
                db.insertUser(newUser);
//                loadSpinner();
                Toast.makeText(getApplicationContext(), "User added" ,Toast.LENGTH_SHORT);


            }

            private void loadSpinner() {
                DatabaseHandler db=new DatabaseHandler(getApplicationContext());
                List<User> users=db.getAllUser();

                List<User> allusers=db.getAllUser();
                List<String> usernames=null;
                for(User user: allusers)
                {
                    usernames.add(user.getUserName());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, usernames);
                adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);


                sp.setAdapter(adapter);
            }
        });


    }
}