package com.quickshop.respository;

import com.google.common.collect.Maps;
import com.quickshop.data.Product;
import com.quickshop.data.RecommendationData;

import java.util.Map;

/**
 * Created by hgelb on 3/7/2016.
 */
public class ProductsRepositoryImpl implements ProductsRepository {

    static Map<String, Product> productsMap = Maps.newHashMap();

    public ProductsRepositoryImpl() {
        initProductsMap();
    }


    private void initProductsMap(){
        productsMap.put("123", new Product("123", "milk_123", "Milk", 5.6, new RecommendationData("Buy milk","sale")));
        productsMap.put("7290008464406", new Product("7290008464406", "resources/pepsi_7290008464406", "Pepsi Max", 8.0, new RecommendationData("Buy pepsy","sale_max")));
        productsMap.put("7290104068539", new Product("7290104068539", "resources/gum_7290104068539", "MUST Fruit", 7.5, new RecommendationData("Buy gum","off5050")));
    }

    @Override
    public Product getProductById(String id){
        return productsMap.get(id);
    }

    private String getImageUrlByName(String imgName) {
        return getClass().getClassLoader().getResource(imgName).getPath();
    }
}
