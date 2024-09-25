package com.example.skillwill15.Services;

import com.example.skillwill15.Models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneService {
    private final List<Product> phoneList = new ArrayList<>();

    public String addPhone(Product phone, String productType, String price, String quantity) {
        phone.setProductType(productType);
        phone.setPrice(price);
        phone.setQuantity(quantity);
        phoneList.add(phone);
        return "Phone Added Successfully";
    }

    public Product getPhoneByType(String productType) {
        return phoneList.stream()
                .filter(phone -> phone.getProductType().equalsIgnoreCase(productType))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getAllPhones() {
        return phoneList;
    }

    public String removePhone(String productType) {
        Product phoneToRemove = getPhoneByType(productType);
        if (phoneToRemove != null) {
            phoneList.remove(phoneToRemove);
            return "Phone Removed Successfully";
        }
        return "Phone Not Found";
    }
}
