package com.example.listview;

import android.app.AlertDialog;
import android.app.LauncherActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    String[] boys;
    Button closeBtn;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);listview=findViewById(R.id.listView);
       boys=getResources().getStringArray(R.array.ITBoys);


       final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
               R.layout.itemstyle,R.id.itemTextView
       ,boys);

       listview.setAdapter(adapter);

       listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               String value=adapter.getItem(i);
               Toast.makeText(getApplicationContext(), value,Toast.LENGTH_SHORT).show();}
       });

    //Popup builder for creating Alert Dialog Box
        closeBtn=findViewById(R.id.close);

       builder=new AlertDialog.Builder(this);
       closeBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               builder.setMessage("Do you want to close app?")
                       .setCancelable(false)
                       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               finish();
                               Toast.makeText(getApplicationContext(),"Yes you chose",
                                       Toast.LENGTH_SHORT).show();
                           }
                       })
                       .setNegativeButton("No", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               dialogInterface.cancel();
                               Toast.makeText(getApplicationContext(),"No you chose",
                                       Toast.LENGTH_SHORT).show();
                           }
                       });

               AlertDialog alert= builder.create();
               alert.setTitle("Close app");
               alert.show();
           }
       });



    }
}