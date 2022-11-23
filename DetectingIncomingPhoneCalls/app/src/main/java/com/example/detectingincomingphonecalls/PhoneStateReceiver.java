package com.example.detectingincomingphonecalls;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class PhoneStateReceiver  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            //Detecta o estado da ligação
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
           
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                Toast.makeText(context, "Esta Tocando", Toast.LENGTH_SHORT).show();
            }
            if (state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){
                Toast.makeText(context, "Chamada Recebida", Toast.LENGTH_SHORT).show();
            }
            if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)){
                Toast.makeText(context, "Inativo", Toast.LENGTH_SHORT).show();
            }

            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
