package com.example.sharedpref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PreferrenceActivity extends AppCompatActivity {

    private EditText username, pass;
    private Button save;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferrence);

        // Initialize views
        username = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        save = findViewById(R.id.save); // Assuming the button ID is btnSave

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("tag", "onClick: Save button clicked");

                // Retrieve the input from EditText fields
                String user = username.getText().toString();
                String password = pass.getText().toString();

                // Save the data to SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", user);
                editor.putString("password", password);
                editor.apply();

                // Show a confirmation message
                Toast.makeText(PreferrenceActivity.this, "Preferences saved", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
