package com.prasannakc.dissertation;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;


public class Moms extends ActionBarActivity {

    Button bt_ON, bt_OFF,disc_devicesbtn,searchdevicesbtn,pairbtdevicesbtn;
    private BluetoothAdapter btadapter=  BluetoothAdapter.getDefaultAdapter();
    public static final int DISCOVERY_REQUEST =1;
    ArrayAdapter<String>  listadapter;
    Set<BluetoothDevice> deviceArray;
    ArrayList<String> pairedDevices;

    BroadcastReceiver receiver;



    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moms);
        init();
        bt_ON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               turnOn();
            }
        });// bluetooth turning on .....

        bt_OFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOff();
            }
        });
        pairbtdevicesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listadapter.clear();
                getPairedDevices();
            }
        });
        searchdevicesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dicoverDevice();
            }
        });

        disc_devicesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dicoverDevice();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_CANCELED)
        {
            Toast.makeText(getApplicationContext(), "Bluetooth must be enabled to continue", Toast.LENGTH_SHORT).show();
            finish();
        }
        else if(resultCode == DISCOVERY_REQUEST) {
            Toast.makeText(getApplicationContext(), "Discovery in Progress", Toast.LENGTH_SHORT).show();
        }

    }
    //methods implementation

    public void init()
    {
        bt_ON = (Button)findViewById(R.id.bt_ON);
        bt_OFF = (Button)findViewById(R.id.bt_OFF);
        searchdevicesbtn = (Button)findViewById(R.id.searchdevicesbtn);
        pairbtdevicesbtn = (Button)findViewById(R.id.paitbtdevicesbtn);
        disc_devicesbtn = (Button)findViewById(R.id.disc_devicesbtn);
        listView = (ListView)findViewById(R.id.devicesfound);
        listadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,0);
        listView.setAdapter(listadapter);
    }
    private void  turnOn()
    {
        if(btadapter == null) {
            Toast.makeText(getApplicationContext(), "bluetooth not available in this phone", Toast.LENGTH_SHORT).show();
        }else if(!btadapter.isEnabled()){
            Intent btIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(btIntent,1);
            Log.d("Log", "Bluetooth is Enabled");

        }

    }

    private void turnOff()
    {
       if(btadapter.isEnabled()) {
           btadapter.disable();
       }
    }


    private void getPairedDevices() {
        deviceArray = btadapter.getBondedDevices();
        if(deviceArray.size()>0)
        {
            for(BluetoothDevice device: deviceArray)
            {
                listadapter.add(device.getName()+"\n"+device.getAddress());
            }
        }
        if(btadapter.startDiscovery())
        {
            registerReceiver(discoveryResult,new IntentFilter(BluetoothDevice.ACTION_FOUND));
        }
    }
    private void dicoverDevice(){
        String scanModeChanged  = BluetoothAdapter.ACTION_SCAN_MODE_CHANGED;
        String beDiscoverable = BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE;
        IntentFilter filter = new IntentFilter(scanModeChanged);
        registerReceiver(receiver,filter);
        startActivityForResult(new Intent(beDiscoverable),DISCOVERY_REQUEST);
    }


    BroadcastReceiver discoveryResult = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String remoteDeviceName = intent.getStringExtra(BluetoothDevice.EXTRA_NAME);
            BluetoothDevice remoteDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            Toast.makeText(getApplicationContext(),"discovered"+remoteDeviceName,Toast.LENGTH_SHORT).show();

        }
    };

}
