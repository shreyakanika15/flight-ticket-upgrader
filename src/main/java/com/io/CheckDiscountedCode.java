package com.io;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Discount code applied based on Fare Class
public final class CheckDiscountedCode {

    private final static Map<List<String>, String> DISCOUNT_MAP = new HashMap<>() {
        {
            put(List.of("A", "B", "C", "D", "E"), "OFFER_20");
            put(List.of("F", "G", "H", "I", "J", "K"), "OFFER_30");
            put(List.of("L", "M", "N", "O", "P", "Q", "R"), "OFFER_25");
        }
    };

    private CheckDiscountedCode() {
    }

    public static String discountCode(final String fare) {
        Set<Map.Entry<List<String>, String>> entries = DISCOUNT_MAP.entrySet();
        String discount = "";
        for (Map.Entry<List<String>, String> entry : entries) {
            if (entry.getKey().contains(fare.trim().toUpperCase())) {
                discount = entry.getValue();
            }
        }
        return discount;
    }
}
