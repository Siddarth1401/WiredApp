package com.example.ebapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class front_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);
        final DatabaseHandler dbs;
        Button submit,logout;
        final EditText et_name,et_addr,et_com;
        dbs=new DatabaseHandler(this);
        et_name=findViewById(R.id.et_name);
        et_addr=findViewById(R.id.et_addr);
        et_com=findViewById(R.id.at_com);
        submit=findViewById(R.id.sub);
        logout=findViewById(R.id.log);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et_name.getText().toString();
                String address=et_addr.getText().toString();
                String com=et_com.getText().toString();
                if(name.equals("")||address.equals("")||com.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Fields Required", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean insert = dbs.insertdata(name,address,com);
                    if(insert == true){
                        Toast.makeText(getApplicationContext(), "Complaint has been registered", Toast.LENGTH_SHORT).show();

                       }

                    et_name.getText().clear();
                    et_addr.getText().clear();
                    et_com.getText().clear();




                }
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte=new Intent(getApplicationContext(),login.class);
                startActivity(inte);
            }
        });

    }
}
