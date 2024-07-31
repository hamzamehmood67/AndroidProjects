package com.example.question2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button OrderNow;
    CheckBox pizza,coffee,burger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        OrderNow= findViewById(R.id.button);
        pizza=findViewById(R.id.pizza);
        coffee=findViewById(R.id.coffee);
        burger=findViewById(R.id.burger);



        OrderNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int totalAmount = 0;
                StringBuilder result = new StringBuilder();
                result.append("Selected Items:\n");

                if (pizza.isChecked()) {
                    result.append("Pizza 100Rs\n");
                    totalAmount += 100;
                }
                if (coffee.isChecked()) {
                    result.append("Coffee 50Rs\n");
                    totalAmount += 50;
                }
                if (burger.isChecked()) {
                    result.append("Burger 120Rs\n");
                    totalAmount += 120;
                }
                result.append("Total: ").append(totalAmount).append("Rs");
                Intent i= new Intent(MainActivity.this, MainActivity2.class);
                String msj=result.toString();
                i.putExtra("str",msj);

                startActivity(i);
                }
        });

    }
}