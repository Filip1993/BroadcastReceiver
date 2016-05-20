package com.filipkesteli.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //privatne varijable kao elementi sucelja
    private Button btnSend;

    //privatne varijable kao elementi za poslovnu logiku
    private Receiver receiver;


    //pozicioniramo metode kak se sto izvrsava logicno:
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();
    }

/*    @Override
    protected void onResume() {
        super.onResume();
        //moramo imati intent filter kao u manifestu...
        IntentFilter intentFilter = new IntentFilter(Receiver.INTENT_NAME);
        //za sad imamo samo filter i sad ga moramo zakaciti za klasu Receiver
        //najprije trebamo dohvatiti Receiver, pa onda ga otkaciti:
        receiver = new Receiver();
        registerReceiver(receiver, intentFilter);
    }*/

    private void initWidgets() {
        btnSend = (Button) findViewById(R.id.btnSend);
    }

    private void setupListeners() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hocemo dokazati da ovaj receiver nece slusati.....
                //implicitni intent -> hocemo pogoditi INTENT_NAME i PARAMETER_NAME
                //hocu postic da operativni sustav odluci kam ce ic -> to je smisao BROADCAST RECEIVERA
                Intent intent = new Intent(Receiver.INTENT_NAME);
                intent.putExtra(Receiver.PARAMETER_NAME, getString(R.string.message));
                sendBroadcast(intent);
            }
        });
    }

    /*@Override
    protected void onPause() {
        super.onPause();
        //znam da ce slusat jer sam ga ja registrirao:
        unregisterReceiver(receiver);
    }*/
}
