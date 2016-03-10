package com.quickshop.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.quickshop.activity.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goToCart(View view) {
        System.out.println("go to cart");
        Intent intent = new Intent(this, TotalProductsActivity.class);
        startActivity(intent);
    }
}