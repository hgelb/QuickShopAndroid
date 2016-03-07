package com.example.user.quickshopandroidapp;

import android.content.Intent;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ScannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        {
            if (requestCode == IntentIntegrator.REQUEST_CODE) {
                IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
                if (scanResult != null) {
                    // handle scan result
                    //MessageBox.run(this, "", "toString() returns: " + scanResult.toString());
                } else {
                    // else continue with any other code you need in the method
                    // MessageBox.run(this, "", "scanResult is null.");
                }
            }
        }

    }

}
