package com.quickshop.respository;

import com.quickshop.data.Product;

/**
 * Created by hgelb on 3/7/2016.
 */
public interface ProductsRepository {

    Product getProductById(String id);
}
