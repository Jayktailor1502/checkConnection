package com.example.checkconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    Boolean isConnect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void checkIt(View view) {
        if (isConnected()) {
            Toast.makeText(getApplicationContext(), "Mobile Data Connection", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "WiFi Connection", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cm.getActiveNetworkInfo();
        boolean isWiFi = nInfo.getType() == ConnectivityManager.TYPE_WIFI;
        boolean isMobile = nInfo.getType() == ConnectivityManager.TYPE_MOBILE;
        if (isMobile == true) {
            isConnect = true;
        } else {
            isConnect = false;
        }
        return isConnect;
    }
}