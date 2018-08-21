package com.prasannakc.dissertation;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class CalculateNEWS extends ActionBarActivity {

    private EditText et_o2sat, et_pulse, et_resp, et_sysbp, et_temp, et_score;
    private Button btn_clear, btn_cal_news;
    private TextView score;
    private Spinner sp_supp_o2, sp_level;
    private int o2sat, pulse, resp, sysbp;
    private double temp;
    private String suup, level;
    int scored = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_news);
        et_o2sat = (EditText) findViewById(R.id.et_o2sat);
        et_pulse = (EditText) findViewById(R.id.et_pulse);
        et_resp = (EditText) findViewById(R.id.et_resp);
        et_sysbp = (EditText) findViewById(R.id.et_sysbp);
        et_temp = (EditText) findViewById(R.id.et_temp);
        et_score = (EditText) findViewById(R.id.et_score);
        score = (TextView) findViewById(R.id.score);
        sp_supp_o2 = (Spinner) findViewById(R.id.sp_supp_o2);
        sp_level = (Spinner) findViewById(R.id.sp_level);

        btn_cal_news = (Button) findViewById(R.id.btn_cal_news);
        btn_clear = (Button) findViewById(R.id.btn_clear);

        et_o2sat.requestFocus();
        score.setVisibility(View.INVISIBLE);
        et_score.setVisibility(View.INVISIBLE);


        //clearing all edit text boxes with the button click
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                et_o2sat.setText("");
                et_sysbp.setText("");
                et_pulse.setText("");
                et_resp.setText("");
                et_temp.setText("");
            }
        });

        // calculate news with the given data either by the patient or the nurse

        btn_cal_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                score.setVisibility(View.VISIBLE);
                et_score.setVisibility(View.VISIBLE);

                //Toast.makeText(CalculateNEWS.this, "Calculate NEWS button has been clicked" , Toast.LENGTH_SHORT).show();

                o2sat = Integer.parseInt(et_o2sat.getText().toString());
                pulse = Integer.parseInt(et_pulse.getText().toString());
                suup = String.valueOf(sp_supp_o2.getSelectedItem());
                // Toast.makeText(CalculateNEWS.this, "saturated o2 is:" +o2sat, Toast.LENGTH_SHORT).show();
                // Toast.makeText(CalculateNEWS.this, "pulse rate is" +pulse, Toast.LENGTH_SHORT).show();
                Toast.makeText(CalculateNEWS.this, "supplement o2" + suup, Toast.LENGTH_SHORT).show();
                if (o2sat <= 94) {
                    scored = 1;
                    et_score.setText(Integer.toString(scored));//displaying score in edit text
                }


            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculate_new, menu);
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
