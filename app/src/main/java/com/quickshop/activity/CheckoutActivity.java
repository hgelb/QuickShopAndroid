package com.quickshop.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.quickshop.activity.R;

import java.text.DecimalFormat;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        double sum = CartContent.getInstance().updateTotalPrice();

        TextView total = (TextView) findViewById(R.id.totalToCheckout);
        total.setText("Total to Checkout:  " + String.valueOf(new DecimalFormat("##.##").format(sum)));
    }

    public void goToPayPal(View view){
        playSound();
        Log.v(CheckoutActivity.this.getLocalClassName(), "go to paypal");
        Uri uri = Uri.parse("https://www.paypal.com/signin/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void playSound(){
        Log.v(CheckoutActivity.this.getLocalClassName(), "playSound");
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.bell);
        mp.start();
    }
}
