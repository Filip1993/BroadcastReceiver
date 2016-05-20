package com.filipkesteli.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

    //zelimo da se netko drugi moze nama obratit -> public konstanta
    public static final String INTENT_NAME = "com.filipkesteli.broadcastreceiver.Receiver";
    public static final String PARAMETER_NAME = "receiver.param";

    //on u svojoj hijerarhiji ne nasljeduje context, pa imamo context u metodi
    //ili u metodama ili u constructoru -> context je Handler za pristup resursima!!
    @Override
    public void onReceive(Context context, Intent intent) {
        //kada me netko trzne, hocu vidjet da li intent ima ovaj parametar!
        if (intent.hasExtra(PARAMETER_NAME)) {
            String value = intent.getStringExtra(PARAMETER_NAME);
            //imamo context kao parametar!
            Toast.makeText(context, value, Toast.LENGTH_SHORT).show();
        }

        //Tko mene sad moze trznut? Samo eksplicitno -> dok traje aplikacija -> dok je ziva
    }
}
