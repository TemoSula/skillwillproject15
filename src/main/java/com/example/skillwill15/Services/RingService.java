package com.example.skillwill15.Services;

import com.example.skillwill15.Models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RingService {
    private final List<Product> ringList = new ArrayList<>();

    public String addRing(Product ring, String productType, String price, String quantity) {
        ring.setProductType(productType);
        ring.setPrice(price);
        ring.setQuantity(quantity);
        ringList.add(ring);
        return "Ring Added Successfully";
    }

    public Product getRingByType(String productType) {
        return ringList.stream()
                .filter(ring -> ring.getProductType().equalsIgnoreCase(productType))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getAllRings() {
        return ringList;
    }

    public String removeRing(String productType) {
        Product ringToRemove = getRingByType(productType);
        if (ringToRemove != null) {
            ringList.remove(ringToRemove);
            return "Ring Removed Successfully";
        }
        return "Ring Not Found";
    }
}
