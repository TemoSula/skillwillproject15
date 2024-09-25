package com.example.skillwill15.Controllers;

import com.example.skillwill15.Models.Product;
import com.example.skillwill15.Services.ComputerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computers")
public class ComputerController {



        private final ComputerService computerService;
        private final Product computer;

        public ComputerController(ComputerService computerService, @Qualifier("technique-items") Product computer) {
            this.computerService = computerService;
            this.computer = computer;
        }

        @PostMapping("/add")
        public String addComputer(@RequestParam String productType, @RequestParam String price, @RequestParam String quantity) {
            return computerService.addComputer(computer, productType, price, quantity);
        }

        @GetMapping("/{productType}")
        public Product getComputer(@PathVariable String productType) {
            return computerService.getComputerByType(productType);
        }

        @GetMapping("/all")
        public List<Product> getAllComputers() {
            return computerService.getAllComputers();
        }

        @DeleteMapping("/remove/{productType}")
        public String removeComputer(@PathVariable String productType) {
            return computerService.removeComputer(productType);
        }
}
