package com.prasannakc.dissertation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Signin extends Activity {

    private Button login,btnLinkToRegisterScreen;
    private EditText email, password;
    String EMAIL, PASSWORD;
    Context ctx = this;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

//FirebaseAuth.getInstance().signOut();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setApplicationId("1:385415922258:android:0080cdc75472f948") // Required for Analytics.
                .setApiKey("AIzaSyDdhe3DzzDuv0YDLLhzrs7M92vzQJWWFoI") // Required for Auth.
//                .setDatabaseUrl("YOUR_DATABASE_URL") // Required for RTDB.
//                // ...
                .build();

        FirebaseApp.initializeApp(Signin.this, options);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        // ...
        mAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!= null) {
                    startActivity(new Intent(Signin.this, Home.class));
                }
            }
        };


        login = (Button) findViewById(R.id.btnLogin);
        btnLinkToRegisterScreen = (Button) findViewById(R.id.btnLinkToRegisterScreen);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        //validating email
        if (email.getText().toString().length() == 0) {
            email.setError("Email is required!");
        }

        //validating password
        if (password.getText().toString().length() == 0)
            password.setError("Enter Password!");


        if (email.getText().toString().equals("prasanna@gmail.com")) {
            Toast.makeText(Signin.this, "email verified", Toast.LENGTH_SHORT).show();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                DatabaseHandler dbh = new DatabaseHandler(ctx);
//                Cursor cr = dbh.getInformation(dbh);
//                cr.moveToFirst();
//
//
//                if ((email.getText().toString().equals("prasanna@gmail.com")) && (password.getText().toString().equals("password"))) {
//                    Toast.makeText(Signin.this, "email verified", Toast.LENGTH_SHORT).show();
//                    Intent logintent = new Intent(Signin.this, Home.class);
//                    startActivity(logintent);
//                    finish();
//                } else if ((email.getText().toString().equals("chowdary@gmail.com")) && (password.getText().toString().equals("password1"))) {
//                    Intent logintent = new Intent(Signin.this, Home.class);
//                    startActivity(logintent);
//                } else
//                    Toast.makeText(Signin.this, "Entered credential did not matched", Toast.LENGTH_SHORT).show();
                signIn();





            }
        });


        btnLinkToRegisterScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent regintent = new Intent(Signin.this, Signup.class);
                startActivity(regintent);
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);

    }

    private void signIn() {

        String emailText = email.getText().toString();
        String passwordText = password.getText().toString();

        if(TextUtils.isEmpty(emailText)|| TextUtils.isEmpty(passwordText)) {
            Toast.makeText(Signin.this, "Fields are empty", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(Signin.this, "Trying to auth", Toast.LENGTH_SHORT).show();

            mAuth.signInWithEmailAndPassword(emailText, passwordText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (!task.isSuccessful()) {
                        Toast.makeText(Signin.this, "SignIn Problem", Toast.LENGTH_SHORT).show();

                    }

                }
            });
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
