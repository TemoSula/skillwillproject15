package com.example.skillwill15.Controllers;

import com.example.skillwill15.Models.Product;
import com.example.skillwill15.Services.PhoneService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhoneController {

    private final PhoneService phoneService;
    private final Product phone;

    public PhoneController(PhoneService phoneService, @Qualifier("communication-items") Product phone) {
        this.phoneService = phoneService;
        this.phone = phone;
    }

    @PostMapping("/add")
    public String addPhone(@RequestParam String productType, @RequestParam String price, @RequestParam String quantity) {
        return phoneService.addPhone(phone, productType, price, quantity);
    }

    @GetMapping("/{productType}")
    public Product getPhone(@PathVariable String productType) {
        return phoneService.getPhoneByType(productType);
    }

    @GetMapping("/all")
    public List<Product> getAllPhones() {
        return phoneService.getAllPhones();
    }

    @DeleteMapping("/remove/{productType}")
    public String removePhone(@PathVariable String productType) {
        return phoneService.removePhone(productType);
    }
}
