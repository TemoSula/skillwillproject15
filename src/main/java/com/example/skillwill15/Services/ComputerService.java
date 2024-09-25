package com.example.skillwill15.Services;

import com.example.skillwill15.Models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComputerService {

    private final List<Product> computerList = new ArrayList<>();

    public String addComputer(Product computer, String productType, String price, String quantity) {
        computer.setProductType(productType);
        computer.setPrice(price);
        computer.setQuantity(quantity);
        computerList.add(computer);
        return "Computer Added Successfully";
    }

    public Product getComputerByType(String productType) {
        return computerList.stream()
                .filter(computer -> computer.getProductType().equalsIgnoreCase(productType))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getAllComputers() {
        return computerList;
    }

    public String removeComputer(String productType) {
        Product computerToRemove = getComputerByType(productType);
        if (computerToRemove != null) {
            computerList.remove(computerToRemove);
            return "Computer Removed Successfully";
        }
        return "Computer Not Found";
    }


}
