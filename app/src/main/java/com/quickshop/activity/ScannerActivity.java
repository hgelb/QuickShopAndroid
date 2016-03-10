package com.quickshop.activity;

import android.content.Intent;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ScannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        IntentIntegrator integrator = new IntentIntegrator(this);
        AlertDialog res = integrator.initiateScan();

    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, TotalProductsActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == IntentIntegrator.REQUEST_CODE)
        {
            IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if(scanResult.getContents() == null)
            {
                Intent intent = new Intent(this, TotalProductsActivity.class);
                startActivity(intent);
            }
            else {
                String productId = scanResult.getContents();
                Intent intent = new Intent(this, ScannerResultActivity.class);
                intent.putExtra("PRODUCT_ID", productId);
                startActivity(intent);
            }

        }

    }



}
