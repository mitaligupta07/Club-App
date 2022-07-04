package com.example.vitclubapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    EditText name;
    EditText Email;
    EditText Password;
    EditText CfmPassword;
    Button Login;
    Button SelClubs;
    Button go;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (EditText) findViewById(R.id.EditText2);
        Email = (EditText) findViewById(R.id.EditText3);
        Password = (EditText) findViewById(R.id.EditText4);
        CfmPassword = (EditText) findViewById(R.id.EditText5);
        Login = (Button) findViewById(R.id.button5);
        go = (Button) findViewById(R.id.button4);
        SelClubs = (Button) findViewById(R.id.button3);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainActivityIntent = new Intent(Register.this, MainActivity.class);
                startActivity(MainActivityIntent);
            }
        });
        SelClubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SelectClubIntent = new Intent(Register.this, SelectClub.class);
                startActivity(SelectClubIntent);
            }
        });
        firebaseAuth= FirebaseAuth.getInstance();
        progressDialog= new ProgressDialog(this);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });}
        private void Register() {
            String getname = name.getText().toString();
            String email = Email.getText().toString();
            String paasword1 = Password.getText().toString();
            String password2 = CfmPassword.getText().toString();
            if (TextUtils.isEmpty(getname)) {
                name.setError("Enter your name");
                return;
            }
            if (TextUtils.isEmpty(email)) {
                Email.setError("Enter your email");
                return;
            } else if (TextUtils.isEmpty(paasword1)) {
                Password.setError("Enter your password");
                return;
            } else if (TextUtils.isEmpty(password2)) {
                CfmPassword.setError("Confirm your password");
                return;
            } else if (!paasword1.equals(password2)) {
                CfmPassword.setError("Different password");
            } else if (paasword1.length() < 4) {
                Password.setError("Length should be > 4");
                return;
            } else if (!isVallidEmail(email)) {
                Email.setError("Invalid Email");
                return;
            }


            progressDialog.setMessage("Please wait...");
            progressDialog.show();
            progressDialog.setCanceledOnTouchOutside(false);
            firebaseAuth.createUserWithEmailAndPassword(email,paasword1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Register.this,"Successfully registered",Toast.LENGTH_LONG).show();
                        Intent intent= new Intent(Register.this, SelectClub.class);
                        startActivity(intent);
                        finish();
                }
                    else{
                        Toast.makeText(Register.this,"Sign up failed", Toast.LENGTH_LONG).show();
                    }
                    progressDialog.dismiss();
            }
        });
    }

        private Boolean isVallidEmail(CharSequence target) {
            return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
        }



    }
