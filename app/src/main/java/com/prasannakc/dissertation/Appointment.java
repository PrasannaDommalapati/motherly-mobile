package com.prasannakc.dissertation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Appointment extends ActionBarActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        ArrayList<Hospitals_list> searchResults = GetSearchResults();
       final  Bundle post = new Bundle();



        final ListView lv1 = (ListView) findViewById(R.id.listView);
        lv1.setAdapter(new MyCustomBaseAdapter(this, searchResults));
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object obj =  (Object)lv1.getItemAtPosition(position);
                Hospitals_list fullObject = (Hospitals_list)obj;

                String str = fullObject.getName();

                if(str.equals("St Nicholas Hospital"))
                {
                    Toast.makeText(Appointment.this, "You have chosen: " + " "+fullObject.getName() , Toast.LENGTH_LONG).show();

                    post.putString("hos",str);
                    Intent in = new Intent(Appointment.this,Doctors_list.class);
                    in.putExtras(post);
                    startActivity(in);
                }else if(str.equals("R V I Hospital"))
                {
                    Toast.makeText(Appointment.this, "You have chosen: " + " "+fullObject.getName() , Toast.LENGTH_LONG).show();

                    post.putString("hos",str);
                    Intent in = new Intent(Appointment.this,Doctors_list.class);
                    in.putExtras(post);
                    startActivity(in);
                }else if(str.equals("General Hospital"))
                {

                    post.putString("hos",str);
                    Intent in = new Intent(Appointment.this,Doctors_list.class);
                    in.putExtras(post);
                    startActivity(in);
                    Toast.makeText(Appointment.this, "You have chosen: " + " "+fullObject.getName() , Toast.LENGTH_LONG).show();
                }
                else if(str.equals("St Georges Hospital"))
                {
                    Toast.makeText(Appointment.this, "You have chosen: " + " "+fullObject.getName() , Toast.LENGTH_LONG).show();

                    post.putString("hos",str);
                    Intent in = new Intent(Appointment.this,Doctors_list.class);
                    in.putExtras(post);
                    startActivity(in);
                }
                else if(str.equals("North Gate Hospital"))
                {
                    Toast.makeText(Appointment.this, "You have chosen: " + " "+fullObject.getName() , Toast.LENGTH_LONG).show();

                    post.putString("hos",str);
                    Intent in = new Intent(Appointment.this,Doctors_list.class);
                    in.putExtras(post);
                    startActivity(in);
                }
            }
        });
    }

    private ArrayList<Hospitals_list> GetSearchResults(){
        ArrayList<Hospitals_list> results = new ArrayList<Hospitals_list>();

        Hospitals_list sr1 = new Hospitals_list();
        sr1.setName("North Gate Hospital");
        sr1.setCityState("Morpeth, NE61 3BP");
        sr1.setPhone("01670 394000");
        results.add(sr1);

        sr1 =  new Hospitals_list();
        sr1.setName("St Georges Hospital");
        sr1.setCityState("Morpeth, Northumberland, NE61 2NU");
        sr1.setPhone("0191 213 0151");
        results.add(sr1);

        sr1 =  new Hospitals_list();
        sr1.setName("General Hospital");
        sr1.setCityState("Westgate Road, Newcastle Upon Tyne, NE4 6BE");
        sr1.setPhone("0191 233 6161");
        results.add(sr1);

        sr1 =  new Hospitals_list();
        sr1.setName("R V I Hospital");
        sr1.setCityState("Queen Victoria Road, Newcastle Upon Tyne, NE1 4LP");
        sr1.setPhone("0191 233 6161");
        results.add(sr1);

        sr1 = new Hospitals_list();
        sr1.setName("St Nicholas Hospital");
        sr1.setCityState("Jublie Road, Gosforth, Newcastle Upon Tyne, NE3 3XT");
        sr1.setPhone("0844 811 5522");
        results.add(sr1);

        return results;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Hospitals_list hlist = new Hospitals_list();

        Toast.makeText(Appointment.this, "You have chosen: " + " " + hlist.getName(), Toast.LENGTH_LONG).show();

    }
}
