package com.prasannakc.dissertation;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Learn extends ActionBarActivity {

    Button glucosebtn;
    Button bloodpressurebtn;
    Button heartratebtn;
    Button temperaturebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        //To learn about HEART RATE
        heartratebtn = (Button)findViewById(R.id.heartratebtn);
        heartratebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://en.wikipedia.org/wiki/Heart_rate"));
                startActivity(browserIntent);
            }
        });

        //To learn about BLOOD PRESSURE
        bloodpressurebtn = (Button)findViewById(R.id.bloodpressurebtn);
        bloodpressurebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://en.wikipedia.org/wiki/Blood_pressure"));
                startActivity(browserIntent);
            }
        });

        //To learn about GLUCOSE
        glucosebtn = (Button)findViewById(R.id. glucosebtn);
        glucosebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://en.wikipedia.org/wiki/Blood_sugar"));
                startActivity(browserIntent);
            }
        });

        //to learn about body TEMPERATURE
        temperaturebtn = (Button)findViewById(R.id.temperaturebtn);
        temperaturebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://en.wikipedia.org/wiki/Human_body_temperature"));
                startActivity(browserIntent);
            }
        });
    }

}
