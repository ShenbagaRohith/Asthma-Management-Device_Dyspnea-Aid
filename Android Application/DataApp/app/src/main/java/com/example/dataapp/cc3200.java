package com.example.dataapp;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class cc3200 extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    Button datachange,refresh;
    TextView welcome,condition;
    String value;
    String[] file = {"name.txt", "age.txt","med.txt","go1.txt","go2.txt","ca1.txt","ca2.txt","da1.txt","da2.txt"};
    int temp=0;
    long v1=0,v2=0,v3=0,v0=0;
    DatabaseReference value0= database.getReference("Mq135");
    DatabaseReference value1= database.getReference("Mq2");
    DatabaseReference value2= database.getReference("Hum");
    DatabaseReference value3= database.getReference("Temp");

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cc3200);
        refresh=findViewById(R.id.rebtn);
        welcome=findViewById(R.id.wtext);
        condition=findViewById(R.id.condition);
        refresh.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (temp == 0) {
                    if (v0 > 200 && v0 < 600 && v1 < 500 && v2 > 30 && v2 < 70 && v3 > 21 && v3 < 48) {
                        condition.setText("Safe");
                        condition.setTextColor(Color.GREEN);
                    } else {
                        condition.setText("Not Safe");
                        condition.setTextColor(Color.RED);
                    }
                } else {
                    condition.setText("Unknown");
                    condition.setTextColor(Color.YELLOW);
                    temp = 0;
                }
            }
        });

        try {
            FileInputStream fileInputStream = openFileInput(file[0]);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuffer = new StringBuilder();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }

            welcome.setText("Welcome "+ stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        datachange=findViewById(R.id.reenter);
        datachange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(cc3200.this,secondactivity.class);
                startActivity(intent2);
            }
        });

        value0.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value = dataSnapshot.getValue(long.class).toString();
                v0=Long.parseLong(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                temp=1;
            }
        });
        value1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value = dataSnapshot.getValue(long.class).toString();
                v1=Long.parseLong(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                temp=1;
            }
        });
        value2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value = dataSnapshot.getValue(long.class).toString();
                v2=Long.parseLong(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                temp=1;
            }
        });
        value3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value = dataSnapshot.getValue(long.class).toString();
                v3=Long.parseLong(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                temp=1;
            }
        });
    }
}
