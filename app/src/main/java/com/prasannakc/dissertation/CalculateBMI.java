package com.prasannakc.dissertation;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class CalculateBMI extends ActionBarActivity {
    Button btn_calBMI;
    EditText etHeight;
    EditText etWeight;
    EditText etBMI;
    Spinner spWt;
    Spinner spHt;
    double h = 0;
    double w = 0;
    double bmi = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);
        btn_calBMI = (Button) findViewById(R.id.btn_calBMI);
        etHeight = (EditText) findViewById(R.id.etHeight);
        etWeight = (EditText) findViewById(R.id.etWeight);
        etBMI = (EditText) findViewById(R.id.etBMI);
        spHt = (Spinner) findViewById(R.id.spHeight);
        spWt = (Spinner) findViewById(R.id.spWeight);
        spWt.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                
                parent.getItemAtPosition(position);

                if(position == 0)
                {
                    Toast.makeText(CalculateBMI.this,"position zero" , Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(CalculateBMI.this,"position other than 0 " , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final String height_units = String.valueOf(spHt.getSelectedItem());
        final String weight_units = String.valueOf(spWt.getSelectedItem());

        btn_calBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h = Double.parseDouble(etHeight.getText().toString());
                w = Double.parseDouble(etWeight.getText().toString());

                // this method is calculating bmi but sill validation needs to be done
               // Toast.makeText(CalculateBMI.this,  "\n Height units \t"+height_units+ " \n weight units"+weight_units, Toast.LENGTH_SHORT).show();
                try
                {
                    
                    if(h!=0)
                    {
                        bmi = w/(h*h);
                        etBMI.setText(Double.toString(bmi));

                    }else
                    {
                        Toast.makeText(CalculateBMI.this,"Height cant be zero to calculate BMI", Toast.LENGTH_SHORT).show();
                    }

                }
                catch(Exception e)
                {
                    Toast.makeText(CalculateBMI.this,"exception is"+e, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3) {

        parent.getItemAtPosition(pos);
        if (pos == 0) {

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.weight_terms,android.R.layout.simple_spinner_item);

            spWt.setAdapter(adapter);

        } else if (pos == 1) {

            ArrayAdapter<CharSequence> adapter = ArrayAdapter

                    .createFromResource(this, R.array.weight_terms,android.R.layout.simple_spinner_item);

            spWt.setAdapter(adapter);

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculate_bmi, menu);
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
