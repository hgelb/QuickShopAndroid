package com.quickshop.activity;

import com.quickshop.data.Product;
import com.quickshop.data.RecommendationData;

import java.util.HashMap;

/**
 * Created by brener on 3/7/2016.
 */
public class ProductItem {

    private Product product;
    private int amount;

    public ProductItem(Product product, int amount)
    {
        this.product = new Product( product.getId(), product.getId(), product.getName(),product.getPrice(), product.getRecommended());
        this.amount = amount;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product m_product) {
        this.product = m_product;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int m_amount) {
        this.amount = m_amount;
    }
}
