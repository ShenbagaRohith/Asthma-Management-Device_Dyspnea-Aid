package com.example.dataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    EditText name1;
    EditText password1;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name1=findViewById(R.id.logid);
        password1=findViewById(R.id.pass);
        button1=findViewById(R.id.btn);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                second(name1.getText().toString(),password1.getText().toString());
            }
        });

    }
    private void second(String name,String Password){
        if((name.equals("Rohith"))&&(Password.equals("1234"))){
            String[] file = {"name.txt", "age.txt","med.txt","go1.txt","go2.txt","ca1.txt","ca2.txt","da1.txt","da2.txt"};
            if (file[0].length() == 0 || file[1].length() == 0 || file[2].length() == 0 || file[3].length() == 0) {
                Intent intent=new Intent(MainActivity.this,secondactivity.class);
                startActivity(intent);
            } else {
                Intent intent=new Intent(MainActivity.this,cc3200.class);
                startActivity(intent);
            }
        }
    }
}
