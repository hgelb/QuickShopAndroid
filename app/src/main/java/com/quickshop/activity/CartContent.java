package com.quickshop.activity;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by brener on 3/7/2016.
 */
public class CartContent {


    private static CartContent Instance;
    private ArrayList<ProductItem> cartContent;

    private CartContent() {
        cartContent = new ArrayList< ProductItem>();
    }
    public ArrayList<ProductItem> getCartContent()
    {
        return cartContent;
    }
    public static CartContent getInstance() {
        if(Instance == null)
            Instance = new CartContent();
        return Instance;
    }

    public void add(ProductItem value) {
        cartContent.add(value);
    }

    public void remove(int index) {
            cartContent.remove(index);
    }

    public void clearAll() {
        cartContent.clear();
    }

    public double updateTotalPrice() {
        double sum = 0;
        Iterator<ProductItem> it = CartContent.getInstance().getCartContent().iterator();
        while (it.hasNext()) {
            ProductItem item = it.next();
            sum += (item.getProduct().getPrice() * item.getAmount());
        }
        return sum;
    }

}

