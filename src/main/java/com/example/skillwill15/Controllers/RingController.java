package com.example.skillwill15.Controllers;

import com.example.skillwill15.Models.Product;
import com.example.skillwill15.Services.RingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rings")
public class RingController {

    private final RingService ringService;
    private final Product ring;

    public RingController(RingService ringService, @Qualifier("accessories") Product ring) {
        this.ringService = ringService;
        this.ring = ring;
    }

    @PostMapping("/add")
    public String addRing(@RequestParam String productType, @RequestParam String price, @RequestParam String quantity) {
        return ringService.addRing(ring, productType, price, quantity);
    }

    @GetMapping("/{productType}")
    public Product getRing(@PathVariable String productType) {
        return ringService.getRingByType(productType);
    }

    @GetMapping("/all")
    public List<Product> getAllRings() {
        return ringService.getAllRings();
    }

    @DeleteMapping("/remove/{productType}")
    public String removeRing(@PathVariable String productType) {
        return ringService.removeRing(productType);
    }
}
