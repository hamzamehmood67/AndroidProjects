package com.example.question4;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Method to handle the click event of the SwitchMaterial
    public void onSwitchClicked(View view) {
        SwitchMaterial switchMaterial = (SwitchMaterial) view;
        boolean isChecked = switchMaterial.isChecked();

        // Perform your action here
        if (isChecked) {
            // Switch is ON
            Toast.makeText(this, "Switch is ON", Toast.LENGTH_SHORT).show();
        } else {
            // Switch is OFF
            Toast.makeText(this, "Switch is OFF", Toast.LENGTH_SHORT).show();
        }
    }
}
