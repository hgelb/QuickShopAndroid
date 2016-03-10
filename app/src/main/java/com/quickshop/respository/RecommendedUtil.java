package com.quickshop.respository;

import com.quickshop.activity.R;
import com.google.common.collect.Maps;

import java.util.Map;

import javax.annotation.PostConstruct;

/**
 * Created by user on 09/03/2016.
 */
public class RecommendedUtil {
    static Map<String, Integer> recommendedMap = Maps.newHashMap();

    public static void init(){
        recommendedMap.put("off5050", R.drawable.off5050);
        recommendedMap.put("sale_max",R.drawable.sale_max);
    }

    public static Integer getRecommByImage(String productName){
        init();
        return recommendedMap.get(productName);
    }
}