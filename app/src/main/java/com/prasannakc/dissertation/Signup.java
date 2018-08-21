package com.prasannakc.dissertation;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Signup extends ActionBarActivity {

   private Button btnLinkToLoginScreen;
    private Button btnRegister;
    EditText name,password,email;
    DatabaseHandler dbHandler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btnLinkToLoginScreen = (Button) findViewById(R.id.btnLinkToLoginScreen);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        dbHandler =new DatabaseHandler(getApplicationContext());




        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //User user = new User(0,"hai","this","is",98493467,"kc","dommalapati","hdh","nsvnv",140588);
                Users user = new Users(0,String.valueOf(name.toString()),String.valueOf(email.toString()),String.valueOf(password.toString()));
                dbHandler.createUser(user);
                Toast.makeText(Signup.this, "user has been created", Toast.LENGTH_SHORT).show();
                int k = dbHandler.getUsersCount();//number of rows inserted into database


                Toast.makeText(Signup.this, "user has been created"+k , Toast.LENGTH_SHORT).show();
                Intent loginIntent= new Intent(Signup.this, Home.class);
                startActivity(loginIntent);
            }
        });


        btnLinkToLoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent loginintent = new Intent(Signup.this, Signin.class);
                startActivity(loginintent);
            }
        });


    }


}
