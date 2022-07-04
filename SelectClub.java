package com.example.vitclubapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;




public class SelectClub extends AppCompatActivity {
    CheckBox ekfrasis;
    CheckBox meraki;
    CheckBox Dance;
    CheckBox software;
    CheckBox nss;
    Button ekfrasisInfo;
    Button merakiInfo;
    Button DanceInfo;
    Button softwareInfo;
    Button nssInfo;
    Button reset;
    Button submit;
    Button home;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_club);
        home=(Button)findViewById(R.id.button17);
        reset=(Button)findViewById(R.id.button15);
        submit=(Button)findViewById(R.id.button16);
        ekfrasis=(CheckBox) findViewById(R.id.radioButton4);
        ekfrasisInfo=(Button)findViewById(R.id.button8);
        meraki=(CheckBox) findViewById(R.id.radioButton5);
        merakiInfo=(Button)findViewById(R.id.button11);
        Dance=(CheckBox) findViewById(R.id.radioButton6);
        DanceInfo=(Button)findViewById(R.id.button10);
        software=(CheckBox) findViewById(R.id.radioButton7);
        softwareInfo=(Button)findViewById(R.id.button9);
        nss=(CheckBox) findViewById(R.id.radioButton9);
        nssInfo=(Button)findViewById(R.id.button12);
        ekfrasisInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ekfrasisInfoIntent= new Intent(SelectClub.this, com.example.vitclubapplication.ekfrasisInfo.class);
                startActivity(ekfrasisInfoIntent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SelectClub.this,MainActivity.class);
                startActivity(intent);
            }
        });
        merakiInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent merakiInfoIntent= new Intent(SelectClub.this, com.example.vitclubapplication.merakiInfo.class);
                startActivity(merakiInfoIntent);
            }
        });
        DanceInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent danceInfoIntent= new Intent(SelectClub.this, com.example.vitclubapplication.DanceInfo.class);
                startActivity(danceInfoIntent);
            }
        });
        softwareInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SoftwareIntent= new Intent(SelectClub.this, Software.class);
                startActivity(SoftwareIntent);
            }
        });
        nssInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nssIntent= new Intent(SelectClub.this, com.example.vitclubapplication.nss.class);
                startActivity(nssIntent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               StringBuffer result= new StringBuffer();
               result.append("My chosen clubs: ");
               if (ekfrasis.isChecked()){
                   result.append("\n"+ ekfrasis.getText().toString());
               }
                if (meraki.isChecked()){
                    result.append("\n"+ meraki.getText().toString());
                }
                if (Dance.isChecked()){
                    result.append("\n"+ Dance.getText().toString());
                }
                if (software.isChecked()){
                    result.append("\n"+ software.getText().toString());
                }
                if (nss.isChecked()){
                    result.append("\n"+ nss.getText().toString());
                }
                if(!ekfrasis.isChecked() && !meraki.isChecked() && !Dance.isChecked() && !software.isChecked() && !nss.isChecked())
                   result.append("\nNone");
                message.message(SelectClub.this, result.toString());
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ekfrasis.isChecked())
                    ekfrasis.setChecked(false);
                if(meraki.isChecked())
                    meraki.setChecked(false);
                if(Dance.isChecked())
                    Dance.setChecked(false);
                if(software.isChecked())
                    software.setChecked(false);
                if(nss.isChecked())
                    nss.setChecked(false);
            }
        });

    }
}