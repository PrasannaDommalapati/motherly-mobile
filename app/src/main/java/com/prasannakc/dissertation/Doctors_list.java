package com.prasannakc.dissertation;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class Doctors_list extends ActionBarActivity {

    ListView list_st_Doc,list_gen_doc,list_rvi_doc,list_stgeo_doc, list_north_doc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_list);
        list_st_Doc = (ListView)findViewById(R.id.list_stnic_Doc);
        list_gen_doc = (ListView)findViewById(R.id.list_gen_Doc);
        list_rvi_doc = (ListView)findViewById(R.id.list_rvi_Doc);
        list_stgeo_doc = (ListView)findViewById(R.id.list_stgeo_doc);
        list_north_doc = (ListView)findViewById(R.id.list_north_doc);

        list_st_Doc.setVisibility(View.INVISIBLE);
        list_gen_doc.setVisibility(View.INVISIBLE);
        list_rvi_doc.setVisibility(View.INVISIBLE);
        list_north_doc.setVisibility(View.INVISIBLE);
        list_stgeo_doc.setVisibility(View.INVISIBLE);


        Bundle get = getIntent().getExtras();
        String st = get.getString("hos");


        if(st.equals("St Nicholas Hospital")){
            list_st_Doc.setVisibility(View.VISIBLE);


            list_st_Doc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String selectedFromList = (list_st_Doc.getItemAtPosition(position).toString());
                    Toast.makeText(Doctors_list.this, "Doctor name is "+selectedFromList , Toast.LENGTH_LONG).show();
                }
            });


        }else if(st.equals("R V I Hospital"))
        {
            list_rvi_doc.setVisibility(View.VISIBLE);

            list_rvi_doc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String selectedFromList = (list_rvi_doc.getItemAtPosition(position).toString());
                    Toast.makeText(Doctors_list.this, "Doctor name is:- "+selectedFromList , Toast.LENGTH_LONG).show();
                }
            });
        }else if(st.equals("General Hospital"))
        {
            list_gen_doc.setVisibility(View.VISIBLE);

            list_gen_doc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String selectedFromList = (list_gen_doc.getItemAtPosition(position).toString());
                    Toast.makeText(Doctors_list.this, "Doctor name is:- "+selectedFromList , Toast.LENGTH_LONG).show();
                }
            });
        }else if(st.equals("North Gate Hospital"))
        {
            list_north_doc.setVisibility(View.VISIBLE);
            list_north_doc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String selectedFromList = (list_north_doc.getItemAtPosition(position).toString());
                    Toast.makeText(Doctors_list.this, "Doctor name is:- "+selectedFromList , Toast.LENGTH_LONG).show();
                }
            });

        }else if(st.equals("St Georges Hospital"))
        {
            list_stgeo_doc.setVisibility(View.VISIBLE);
            list_stgeo_doc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String selectedFromList = (list_stgeo_doc.getItemAtPosition(position).toString());
                    Toast.makeText(Doctors_list.this, "Doctor name is:- "+selectedFromList , Toast.LENGTH_LONG).show();
                }
            });
        }




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_doctors_list, menu);
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
