package com.example.dataapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class secondactivity extends AppCompatActivity {

    EditText name;
    EditText age;
    EditText med;
    EditText go1,go2,ca1,ca2,da1,da2;
    Button save,tranfer;
    String[] file = {"name.txt", "age.txt","med.txt","go1.txt","go2.txt","ca1.txt","ca2.txt","da1.txt","da2.txt"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        name=findViewById(R.id.sname);
        age=findViewById(R.id.sage);
        med=findViewById(R.id.smed);
        go1=findViewById(R.id.g1);
        go2=findViewById(R.id.g2);
        ca1=findViewById(R.id.c1);
        ca2=findViewById(R.id.c2);
        da1=findViewById(R.id.d1);
        da2=findViewById(R.id.d2);
        save=findViewById(R.id.button2);
        tranfer=findViewById(R.id.tran);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeFile();
            }
        });

        tranfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(secondactivity.this,cc3200.class);
                startActivity(intent1);
            }
        });

    }
    private void writeFile(){
        String f1,f2,f3,f4,f5,f6,f7,f8,f9;
        f1=name.getText().toString();
        f2=age.getText().toString();
        f3=med.getText().toString();
        f4=go1.getText().toString();
        f5=go2.getText().toString();
        f6=ca1.getText().toString();
        f7=ca2.getText().toString();
        f8=da1.getText().toString();
        f9=da2.getText().toString();

        try {
            FileOutputStream fileOutputStream = openFileOutput(file[0], MODE_PRIVATE);
            fileOutputStream.write(f1.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "file saved", Toast.LENGTH_SHORT).show();
            name.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            FileOutputStream fileOutputStream = openFileOutput(file[1], MODE_PRIVATE);
            fileOutputStream.write(f2.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "file saved", Toast.LENGTH_SHORT).show();
            age.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            FileOutputStream fileOutputStream = openFileOutput(file[2], MODE_PRIVATE);
            fileOutputStream.write(f3.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "file saved", Toast.LENGTH_SHORT).show();
            med.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            FileOutputStream fileOutputStream = openFileOutput(file[3], MODE_PRIVATE);
            fileOutputStream.write(f4.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "file saved", Toast.LENGTH_SHORT).show();
            go1.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            FileOutputStream fileOutputStream = openFileOutput(file[4], MODE_PRIVATE);
            fileOutputStream.write(f5.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "file saved", Toast.LENGTH_SHORT).show();
            go2.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            FileOutputStream fileOutputStream = openFileOutput(file[5], MODE_PRIVATE);
            fileOutputStream.write(f6.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "file saved", Toast.LENGTH_SHORT).show();
            ca1.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            FileOutputStream fileOutputStream = openFileOutput(file[6], MODE_PRIVATE);
            fileOutputStream.write(f7.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "file saved", Toast.LENGTH_SHORT).show();
            ca2.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            FileOutputStream fileOutputStream = openFileOutput(file[7], MODE_PRIVATE);
            fileOutputStream.write(f8.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "file saved", Toast.LENGTH_SHORT).show();
            da1.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            FileOutputStream fileOutputStream = openFileOutput(file[8], MODE_PRIVATE);
            fileOutputStream.write(f9.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "file saved", Toast.LENGTH_SHORT).show();
            da2.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
