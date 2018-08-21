package com.prasannakc.dissertation;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Home extends ActionBarActivity {

    Button btnBMI, btnNEWS, btn_learn, btn_mom, btn_emergency, btn_appoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnBMI = (Button) findViewById(R.id.btn_bmi);
        btnNEWS = (Button) findViewById(R.id.btn_news);
        btn_appoint = (Button) findViewById(R.id.btn_bt_appoint);
        btn_learn = (Button) findViewById(R.id.btn_learn);
        btn_emergency = (Button) findViewById(R.id.btn_emergency);
        btn_mom = (Button) findViewById(R.id.btn_MOM);

        //motherly mobile service activity
        btn_mom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_mom = new Intent(Home.this,Moms.class);
                startActivity(int_mom);
            }
        });

        //learning activity
        btn_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_learn = new Intent(Home.this, Learn.class);
                startActivity(int_learn);
            }
        });

        //booking an appointment
        btn_appoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_appoint = new Intent(Home.this, Appointment.class);
                startActivity(int_appoint);
            }
        });
        //call on emergency
        btn_emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:999"));
                startActivity(callIntent);
            }
        });

        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_bmi = new Intent(Home.this, CalculateBMI.class);
                startActivity(intent_bmi);
            }
        });

        btnNEWS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_news = new Intent(Home.this, CalculateNEWS.class);
                startActivity(intent_news);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
