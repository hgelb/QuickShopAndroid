package com.quickshop.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.quickshop.activity.R;

import java.util.Iterator;

public class TotalProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_products);

        updateTotalPrice();

        retrieveProductId();

        InitGridProduct();
    }

    private void updateTotalPrice() {
        double sum = 0;
        Iterator<ProductItem> it = CartContent.getInstance().getCartContent().iterator();
        while(it.hasNext()) {
            ProductItem item = it.next();
            sum += (item.getProduct().getPrice() * item.getAmount());
        }
        TextView total = (TextView) findViewById(R.id.total);
        total.setText(" Total :      " + String.valueOf(sum));
    }

    private void InitGridProduct()
    {
        final ListView listView = (ListView) findViewById(R.id.listview);
        CustomAdapter adapter = new CustomAdapter(this, CartContent.getInstance().getCartContent());
        listView.setAdapter(adapter);

    }

    public void retrieveProductId()
    {
        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null) {
            String p_id =(String) b.get("PRODUCT_ID");
        }

    }

    public void openScannerActivity(View view) {
        Intent intent = new Intent(this, ScannerActivity.class);
        startActivity(intent);
    }


    public void openCheckoutActivity(View view) {
        Intent intent = new Intent(this, CheckoutActivity.class);
        startActivity(intent);
    }


}

