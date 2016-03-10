
package com.quickshop.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.quickshop.respository.RecommendedUtil;
import com.quickshop.data.Product;
import com.quickshop.respository.ProductsRepository;
import com.quickshop.respository.ProductsRepositoryImpl;

public class ScannerResultActivity extends AppCompatActivity {


    private ProductsRepository productsRepository;
    private int amount = 1;
    private Product serverProduct = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_resault);
        this.productsRepository = new ProductsRepositoryImpl();
        retrieveProductId();
        CreateView();
    }

    public void CreateView()
    {
        final TextView tvProduct = (TextView) findViewById(R.id.product);
        tvProduct.setText(
                serverProduct.getName());
        final TextView tvPrice = (TextView) findViewById(R.id.price);
        tvPrice.setText(String.valueOf(serverProduct.getPrice()));

        final NumberPicker np = (NumberPicker)findViewById(R.id.numberPicker1);
        np.setMinValue(1);
        np.setMaxValue(10);
        np.setWrapSelectorWheel(false);
        amount = np.getValue();
        final ImageView imageView = (ImageView) findViewById(R.id.imageView1);

        getImageByProduct(imageView, serverProduct.getRecommended().getImageURL());


    }
    private void getImageByProduct(ImageView imageView, String productName){
        Log.v(ScannerResultActivity.this.getLocalClassName(), "getImageByProduct");
        Integer path = RecommendedUtil.getRecommByImage(productName);
        imageView.setImageResource(path);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, TotalProductsActivity.class);
        startActivity(intent);
    }

    public void retrieveProductId() {
        Intent iin = getIntent();
        Bundle b = iin.getExtras();

        if (b != null) {
            String p_id = (String) b.get("PRODUCT_ID");
            serverProduct = productsRepository.getProductById(p_id);
        }
    }

    public void cancelOperation(View view)
    {
        moveToScanner();
    }

    public void addToCart(View view)
    {

        ProductItem item = new ProductItem(serverProduct,amount);
        CartContent.getInstance().add(item);

        moveToScanner();

    }

    public void moveToScanner()
    {
        Intent intent = new Intent(this, ScannerActivity.class);
        startActivity(intent);
    }

}
